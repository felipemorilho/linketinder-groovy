package com.acelerazg.services

import com.acelerazg.dao.ApplicantDAO
import com.acelerazg.dao.VacancyDAO
import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant
import com.acelerazg.model.Vacancy

class VacancyService {

    static private VacancyDAO vacancyDAO = new VacancyDAO()

    static Vacancy saveVacancy(String[] registerVacancyData) {

        String jobTitle = registerVacancyData[0]
        String jobDescription = registerVacancyData[1]
        int businessId = registerVacancyData[2].toInteger()

        String skillsString = registerVacancyData[3].replaceAll("[\\[\\]]", '')
        List<Skill> skills = skillsString.tokenize(',').collect { Skill.valueOf(it.trim()) }

        Vacancy vacancy = new Vacancy(jobTitle, jobDescription, businessId, skills)
        vacancyDAO.insertVacancy(vacancy)

        return vacancy
    }
}