package com.acelerazg.dao

import com.acelerazg.model.Applicant
import groovy.sql.Sql

class ApplicantDAO {

    static private DatabaseConnection dbConn

    static void insertApplicant(Applicant applicant) {

        dbConn = new DatabaseConnection()
        Sql conn = dbConn.establishConnection()

        try {

            conn.execute("INSERT INTO applicants (name, age, email, cpf, state, cep, education, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    [applicant.name, applicant.age, applicant.email, applicant.cpf,
                     applicant.state, applicant.cep, applicant.education, applicant.description])

        } catch (Exception e) {
            println("Não foi possível adicionar candidato. Erro: ${e.message}")

        } finally {
            dbConn.closeConnection(conn)
        }

    }
}
