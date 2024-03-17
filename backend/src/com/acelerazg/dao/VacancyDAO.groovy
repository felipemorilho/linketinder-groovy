package com.acelerazg.dao

import com.acelerazg.model.Applicant
import com.acelerazg.model.Vacancy
import groovy.sql.Sql

class VacancyDAO {

    static private DatabaseConnection dbConn = new DatabaseConnection()

    static void insertVacancy(Vacancy vacancy) {

        Sql conn = dbConn.establishConnection()

        try {

            conn.execute("INSERT INTO job_vacancies (job_title, job_description, company_id) " +
                    "VALUES (?, ?, ?)",
                    [vacancy.jobTitle, vacancy.jobDescription, vacancy.businessId])

        } catch (Exception e) {
            println("Não foi possível adicionar vaga. Erro: ${e.message}")

        } finally {
            dbConn.closeConnection(conn)
        }

    }
}
