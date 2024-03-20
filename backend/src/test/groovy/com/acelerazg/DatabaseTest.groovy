package com.acelerazg.test


import com.acelerazg.dao.DatabaseConnection

import groovy.sql.Sql
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import java.sql.SQLException

import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.junit.jupiter.api.Assertions.assertTrue

class DatabaseTest {

    static private DatabaseConnection dbConn


    @BeforeAll
    static void setUp() {

        dbConn = new DatabaseConnection()

    }

    @Test
    void testDBConnection() {

        //Given
        Sql newConn

        //When
        newConn = dbConn.establishConnection()

        //Assert
        assertNotNull(newConn)
    }

    @Test
    void testDBClosure() {

        //Given
        Sql conn = dbConn.establishConnection()

        //When
        dbConn.closeConnection(conn)
        assertNotNull(conn)

        //Then

        try {

            conn.execute("SELECT 1")
            fail("Exceção não lançada")

        } catch (Exception e) {

            assertTrue(e instanceof SQLException)

        }
    }

    /*@Test
    void testCreateNewRow() {

        //Given
        dbService = new DatabaseService()

        String table = "applicants"
        String[] columns = ['name', 'age', 'email', 'cpf', 'state', 'cep', 'education', 'description']
        String[] values = ['Test junit', 1, 'test@mail.com', '999.999.999-99', 'Nowhere', '99999-999', 'Analise e Desenvolvimento de Sistemas', 'Sou dev junior, 1 ano de experiência']

        //When
        dbService.create(values, columns, table)

        //Then
        Sql sql = dbConn.establishConnection()
        try {
            def querySelect = "SELECT * FROM ${table} WHERE name = ? AND age = ? AND email = ? AND cpf = ?" +
                    "AND state = ? AND cep = ? AND education = ? AND description =?"
            def result = sql.firstRow(querySelect, values)

            assertNotNull("Dados incorretos", result)
        } catch (Exception e) {

        } finally {
            dbConn.closeConnection(sql)
        }
    }*/
}
