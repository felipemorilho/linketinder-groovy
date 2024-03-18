package com.acelerazg.dao


import com.acelerazg.model.Vacancy
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

class VacancyDAO {

    static private DatabaseConnection dbConn = new DatabaseConnection()

    static void insertVacancy(Vacancy vacancy) {

        Sql conn = dbConn.establishConnection()

        try {

            conn.execute("INSERT INTO job_vacancies (job_title, job_description, company_id) " +
                    "VALUES (?, ?, ?)",
                    [vacancy.jobTitle, vacancy.jobDescription, vacancy.businessId])


            def vacancyId = conn.firstRow("SELECT id FROM job_vacancies WHERE company_id = ? AND job_title = ?", vacancy.businessId, vacancy.jobTitle).id

            vacancy.skills.forEach{skill ->

                def skillId = conn.firstRow("SELECT id FROM skills WHERE UPPER(name) = ?::text", [skill.toString()]).id

                conn.execute("INSERT INTO job_vacancy_skills (job_vacancy_id, skill_id) " +
                        "VALUES (?, ?)",
                        vacancyId, skillId)
            }

        } catch (Exception ignore) {

            println("Não foi possível adicionar vaga.")

        } finally {

            dbConn.closeConnection(conn)
        }

    }

    static boolean checkIfBusinessExists(int businessId) {

        Sql conn = dbConn.establishConnection()

        GroovyRowResult businessExist = conn.firstRow("SELECT COUNT (*) FROM companies " +
                "WHERE id = ?", businessId)

        dbConn.closeConnection(conn)

        return businessExist[0] > 0
    }
}
