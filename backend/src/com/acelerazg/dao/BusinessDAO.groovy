package com.acelerazg.dao


import com.acelerazg.model.Business
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
            println("Não foi possível adicionar candidato. Erro: ${e.message}")

        } finally {
            dbConn.closeConnection(conn)
        }

    }
}
