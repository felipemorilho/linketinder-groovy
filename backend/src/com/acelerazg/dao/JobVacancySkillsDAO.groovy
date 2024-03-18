package com.acelerazg.dao

import groovy.sql.Sql

class JobVacancySkillsDAO {

    static private DatabaseConnection dbConn = new DatabaseConnection()

    static void linkVacancyAndSkills(int jobVacancyId, int skillId) {

        Sql sql = dbConn.establishConnection()

        try {
            String insertJobSkills = "INSERT INTO job_vacancies_skills (job_vacancyId, skill_id) " +
                    "VALUES (?, ?)"

            sql.execute(insertJobSkills, [jobVacancyId, skillId])

        } catch (Exception ignore) {

            println("Erro ao associar skills e vaga.")
        }
    }
}
