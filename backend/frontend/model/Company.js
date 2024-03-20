"use strict";
class Company {
    constructor(name, email, cnpj, state, country, cep, description) {
        this.name = name;
        this.email = email;
        this.cnpj = cnpj;
        this.state = state;
        this.country = country;
        this.cep = cep;
        this.description = description;
        this.vacancies = [];
    }
    addVacancy(jobTitle, jobDescription, requiredSkills) {
        const vacancy = new JobVacancy(jobTitle, jobDescription, requiredSkills);
        this.vacancies.push(vacancy);
        console.log(`Vacancy added for ${this.name}: ${vacancy.jobTitle}`);
    }
}
class JobVacancy {
    constructor(jobTitle, jobDescription, requiredSkills) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.requiredSkills = requiredSkills;
    }
}
