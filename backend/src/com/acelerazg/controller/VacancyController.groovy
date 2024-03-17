package com.acelerazg.controller

import com.acelerazg.dao.VacancyDAO
import com.acelerazg.model.Vacancy

class VacancyController {

    static private VacancyDAO vacancyDAO = new VacancyDAO()

    static void registerVacancy(Vacancy vacancy) {

        vacancyDAO.insertVacancy(vacancy)

    }

    List<Vacancy> listVacancies() {

        vacancies

    }

}
