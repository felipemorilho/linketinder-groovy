class Company implements User {
    
    name: string;
    email: string;
    cnpj: string;
    state: string;
    country: string;
    cep: string;
    description: string;
    vacancies: JobVacancy[];

    constructor(name: string, email: string, cnpj: string, state: string, country: string, cep: string, description: string) {

        this.name = name;
        this.email = email;
        this.cnpj = cnpj;
        this.state = state;
        this.country = country;
        this.cep = cep;
        this.description = description;
        this.vacancies = [];

    }

    addVacancy(jobTitle: string, jobDescription: string, requiredSkills: string[]) {
        const vacancy = new JobVacancy(jobTitle, jobDescription, requiredSkills);
        this.vacancies.push(vacancy);
        console.log(`Vacancy added for ${this.name}: ${vacancy.jobTitle}`);
    }
}

class JobVacancy {

    jobTitle: string;
    jobDescription: string;
    requiredSkills: string[];

    constructor(jobTitle: string, jobDescription: string, requiredSkills: string[]) {

        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.requiredSkills = requiredSkills;
    }
}