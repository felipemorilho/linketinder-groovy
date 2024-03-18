package com.acelerazg.controller

import com.acelerazg.dao.VacancyDAO
import com.acelerazg.model.Vacancy

class VacancyController {

    static private VacancyDAO vacancyDAO = new VacancyDAO()

    static void registerVacancy(Vacancy vacancy) {

        vacancyDAO.insertVacancy(vacancy)

    }

    static List<Vacancy> listVacancies() {

       List<Vacancy> vacancies = vacancyDAO.readVacancies()

        if(!vacancies.isEmpty()) {

            return vacancies
        }

        println("Não há vagas cadastradas.")

        return null
    }

}
