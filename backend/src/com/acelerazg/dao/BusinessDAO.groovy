package com.acelerazg.dao

import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant
import com.acelerazg.model.Business
import groovy.sql.GroovyRowResult
import groovy.sql.Sql

class BusinessDAO {

    static private DatabaseConnection dbConn = new DatabaseConnection()

    static void insertBusiness(Business business) {

        Sql conn = dbConn.establishConnection()

        try {

            conn.execute("INSERT INTO companies (name, email, cnpj, state, country, cep, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)",
                    [business.name, business.email, business.cnpj,
                     business.state, business.country, business.cep, business.description])

        } catch (Exception e) {

            println("Não foi possível adicionar empresa. Erro: ${e.message}")

        } finally {

            dbConn.closeConnection(conn)
        }

    }

    static List<Business> readBusiness() {

        Sql conn = dbConn.establishConnection()

        List<Business> businesses = []

        try {
            List<GroovyRowResult> rows = conn.rows("SELECT * FROM companies")

            rows.each { row ->

                Business business = new Business(
                        row.name.toString(),
                        row.email.toString(),
                        row.cnpj.toString(),
                        row.state.toString(),
                        row.country.toString(),
                        row.cep.toString(),
                        row.description.toString(),

                )

                businesses.add(business)
            }
        } finally {

            dbConn.closeConnection(conn)
        }

        return businesses

    }
}
