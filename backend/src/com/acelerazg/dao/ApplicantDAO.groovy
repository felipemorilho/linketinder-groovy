package com.acelerazg.dao

import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

class ApplicantDAO {

    static private DatabaseConnection dbConn = new DatabaseConnection()

    static void insertApplicant(Applicant applicant) {

        Sql conn = dbConn.establishConnection()

        try {

            String insertQuery = "INSERT INTO applicants (name, age, email, cpf, state, cep, education, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"

            conn.execute(insertQuery,
                    [applicant.name, applicant.age, applicant.email, applicant.cpf,
                     applicant.state, applicant.cep, applicant.education, applicant.description])

            def applicantId = conn.firstRow("SELECT id FROM applicants WHERE cpf = ?", applicant.cpf).id

            applicant.skills.forEach { skill ->

                def skillId = conn.firstRow("SELECT id FROM skills WHERE UPPER(name) = ?::text", [skill.toString()]).id

                conn.execute("INSERT INTO applicant_skills (applicant_id, skill_id) " +
                        "VALUES (?, ?)",
                        applicantId, skillId)

            }

        } catch (Exception e) {

            println("Não foi possível adicionar candidato. Erro: ${e.message}")

        } finally {

            dbConn.closeConnection(conn)
        }
    }

    static List<Applicant> readApplicants() {

        Sql conn = dbConn.establishConnection()

        List<Applicant> applicants = []

        try {
            List<GroovyRowResult> rows = conn.rows("SELECT * FROM applicants")

            rows.each { row ->
                def applicantId = conn.firstRow("SELECT id FROM applicants WHERE cpf = ?", row.cpf)?.id
                List<Skill> skills = []

                if (applicantId) {
                    List<GroovyRowResult> skillsRows = conn.rows("SELECT name FROM skills" +
                            " INNER JOIN applicant_skills ON skills.id = applicant_skills.skill_id " +
                            " WHERE applicant_skills.applicant_id = ?", [applicantId])

                    skills = skillsRows.collect { it.name.toUpperCase() }.collect { Skill.valueOf(it as String) } as List<Skill>                }

                row.skills = skills

                Applicant applicant = new Applicant(
                        row.name.toString(),
                        row.email.toString(),
                        row.cpf.toString(),
                        row.state.toString(),
                        row.cep.toString(),
                        row.age as int,
                        row.education.toString(),
                        row.description.toString(),
                        skills
                )

                applicants.add(applicant)
            }

        } catch (Exception ignore) {

            println("Erro ao ler dados.")

        } finally {

            dbConn.closeConnection(conn)
        }

        return applicants
    }

    static void updateApplicant(String cpf, Applicant applicant) {

        Sql conn = dbConn.establishConnection()

        try {

            def applicantId = conn.firstRow("SELECT id FROM applicants WHERE cpf = ?", cpf).id

            conn.execute("DELETE FROM applicant_skills WHERE applicant_id = ?", applicantId)

            String updateQuery = "UPDATE applicants SET name=?, age=?, email=?, " +
                    "cpf=?, state=?, cep=?, education=?, description=? WHERE id=?"

            conn.execute(updateQuery, applicant.name, applicant.age, applicant.email,
                    applicant.cpf, applicant.state, applicant.cep,
                    applicant.education, applicant.description, applicantId)

            applicant.skills.forEach { skill ->

                def skillId = conn.firstRow("SELECT id FROM skills WHERE UPPER(name) = ?::text", [skill.toString()]).id

                conn.execute("INSERT INTO applicant_skills (applicant_id, skill_id) " +
                        "VALUES (?, ?)",
                        applicantId, skillId)

            }

        } catch (Exception ignore) {
            println("Erro ao atualizar candidato.")

        } finally {

            dbConn.closeConnection(conn)
        }
    }
}
