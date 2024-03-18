package com.acelerazg.services

import com.acelerazg.dao.JobVacancySkillsDAO
import com.acelerazg.dao.VacancyDAO
import com.acelerazg.enums.Skill
import com.acelerazg.model.Vacancy

class VacancyService {

    static private VacancyDAO vacancyDAO = new VacancyDAO()
    static private JobVacancySkillsDAO jvsDAO = new JobVacancySkillsDAO()

    static Vacancy saveVacancy(String[] registerVacancyData) {

        try {

            String jobTitle = registerVacancyData[0]
            String jobDescription = registerVacancyData[1]
            int businessId = registerVacancyData[2].toInteger()

            boolean businessExist = vacancyDAO.checkIfBusinessExists(businessId)

            if(!businessExist) {

                println("Empresa com ID: ${businessId} não existe.")
                return null
            }

            String skillsString = registerVacancyData[3].replaceAll("[\\[\\]]", '')
            List<Skill> skills = skillsString.tokenize(',').collect { Skill.valueOf(it.trim()) }

            return new Vacancy(jobTitle, jobDescription, businessId, skills)

        } catch (Exception ignore) {

            println("Erro ao cadastrar vaga. Erro ${ignore.message}")
            ignore.printStackTrace()
            return null
        }

    }
}