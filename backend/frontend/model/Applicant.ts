class Applicant implements User {

    name: string;
    age: number;
    email: string;
    cpf: string;
    state: string;
    cep: string;
    education: string;
    description: string;
    skills: string[]

    constructor(name: string, age: number, email: string, cpf: string, state: string, cep: string, education: string, description: string, skills: string[]) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
        this.state = state;
        this.cep = cep;
        this. education = education;
        this.description = description;
        this.skills = skills
        
    }

}