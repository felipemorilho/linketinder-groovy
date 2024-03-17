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

        } catch (Exception e) {
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
