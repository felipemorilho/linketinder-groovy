CREATE TABLE applicants (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age SMALLINT,
    email VARCHAR(100),
    cpf VARCHAR(14),
    state VARCHAR(100),
    cep VARCHAR(9),
    education VARCHAR(255),
    description TEXT
);

CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(100),
    cnpj VARCHAR(18),
    state VARCHAR(100),
    country VARCHAR(100),
    cep VARCHAR(9),
    description TEXT
);

CREATE TABLE skills(
   id SERIAL PRIMARY KEY,
   name VARCHAR(100)
);

CREATE TABLE job_vacancies (
    id SERIAL PRIMARY KEY,
    job_title VARCHAR(100),
    job_description TEXT,
    company_id INT,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE job_vacancy_skills (
    job_vacancy_id INT,
    skill_id INT,
    FOREIGN KEY (job_vacancy_id) REFERENCES job_vacancies(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (job_vacancy_id, skill_id)
);

CREATE TABLE applicant_job_vacancy (
    applicant_id INT,
    job_vacancy_id INT,
    FOREIGN KEY (applicant_id) REFERENCES applicants(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (job_vacancy_id) REFERENCES job_vacancies(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (applicant_id, job_vacancy_id)
);

CREATE TABLE applicant_skills (
    applicant_id INT,
    skill_id INT,
    FOREIGN KEY (applicant_id) REFERENCES applicants(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (applicant_id, skill_id)
);