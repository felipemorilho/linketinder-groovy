package com.acelerazg.controller


import com.acelerazg.model.Vacancy

class VacancyController {

    List<Vacancy> vacancies = []

    void registerVacancy(Vacancy vacancy) {

        vacancies.add(vacancy)

    }

    List<Vacancy> listVacancies() {

        vacancies

    }

}
