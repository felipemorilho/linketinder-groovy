package com.acelerazg.database

import groovy.sql.Sql
import groovy.transform.CompileStatic

@CompileStatic
class DatabaseConnection {

    private static final String url = 'jdbc:postgresql://localhost:5432/linketinder'
    private static final String user = 'postgres'
    private static final String password = 'password'
    private static final String driver = 'org.postgresql.Driver'

    static Sql establishConnection() {
        try {
            return Sql.newInstance(url, user, password, driver)

        } catch (Exception ignored) {
            println("Erro ao conectar com o banco de dados!")
            return null
        }
    }

    static void closeConnection(Sql sql) {
        try {

            if(sql != null) {
                sql.close()
                println("Conexão com o banco de daos finalizada!")
            }
        } catch (Exception e) {

            println("Erro ao fehcar conexão com o banco de dados!")
        }
    }

    void bdCreate(String[] valuesList) {

        Sql sql = establishConnection()

    }

}
