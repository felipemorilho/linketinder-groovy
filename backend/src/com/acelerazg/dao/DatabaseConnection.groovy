package com.acelerazg.dao

import groovy.sql.Sql
import groovy.transform.CompileStatic

@CompileStatic
class DatabaseConnection {

    private static final String url = 'jdbc:postgresql://localhost:5432/linketinder'
    private static final String user = 'postgres'
    private static final String password = 'postgres'
    private static final String driver = 'org.postgresql.Driver'

    static Sql establishConnection() {
        try {
            return Sql.newInstance(url, user, password, driver)

        } catch (Exception e) {
            println("Erro ao conectar com o banco de dados! ${e.message}")
            return null
        }
    }

    static void closeConnection(Sql sql) {
        try {

            if(sql != null) {
                sql.close()
            }
        } catch (Exception e) {

            println("Erro ao fechar conexão com o banco de dados!")
        }
    }

}
