CREATE TABLE applicants (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    age TINYINT,
    email VARCHAR(100),
    cpf VARCHAR(14),
    state VARCHAR(100),
    cep VARCHAR(9),
    education VARCHAR(255),
    description TEXT,
);

CREATE TABLE companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(100),
    cnpj VARCHAR(18),
    state VARCHAR(100),
    country VARCHAR(100),
    cep VARCHAR(9),
    description TEXT,
);

CREATE TABLE job_vacancies (
    id SERIAL PRIMARY KEY,
    job_title VARCHAR(100),
    job_description TEXT,
    company_id INT FOREIGN KEY REFERENCES companies(id) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE job_vacancy_skills (
    job_vacancy_id INT FOREIGN KEY REFERENCES job_vacancies(id) ON DELETE CASCADE ON UPDATE CASCADE,
    skill_id INT FOREIGN KEY REFERENCES skills(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (job_vacancy_id, skill_id)
)

CREATE TABLE applicant_job_vacancy (
    applicant_id INT FOREIGN KEY REFERENCES applicants(id) ON DELETE CASCADE ON UPDATE CASCADE,
    job_vacancy_id INT FOREIGN KEY REFERENCES job_vacancies(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (applicant_id, job_vacancy_id)
)

CREATE TABLE skills(
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100)
    )

CREATE TABLE applicant_skills (
    applicant_id INT FOREIGN KEY REFERENCES applicants(id) ON DELETE CASCADE ON UPDATE CASCADE,
    skill_id INT FOREIGN KEY REFERENCES skills(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (applicant_id, skill_id)
)

INSERT INTO skills (id, name) 
VALUES  ('Java', 'Java'),
        ('Python' = 'Python'),
        ('Groovy' = 'Groovy'),
        ('Spring' = 'Spring'),
        ('JavaScript' = 'JavaScript'),
        ('TypeScript' = 'TypeScript'),
        ('Node' = 'Node'),
        ('Angular' = 'Angular'),
        ('React' = 'React');

INSERT INTO applicants (name, age, email, cpf, state, cep, education, description)
VALUES  ('Juca Tatu', 35, 'juta@mail.com', '111.111.111-11', 'Paraná', '11111-111', 'Tecnólogo em ADS', 'Sou dev junior, sem experiência');

INSERT INTO applicants (name, age, email, cpf, state, cep, education, description)
VALUES  ('Gohan Videl', 21, 'gohan@mail.com', '222.222.333-33', 'Santa Catarina', '22222-222', 'Bacharel em Ciência da Computação', 'Sou dev pleno, 2 anos experiência');

INSERT INTO applicants (name, age, email, cpf, state, cep, education, description)
VALUES  ('Goku no Jutsu', 42, 'goku@mail.com', '333.333.333-33', 'Bahia', '33333-333', 'Superior Completo', 'Tech Lead, dono do universo');

INSERT INTO applicants (name, age, email, cpf, state, cep, education, description)
VALUES  ('Yusuke Urameshi', 32, 'yusuki@mail.com', '444.444.444-44', 'Minas Gerais', '44444-444', 'Superior Completo em Enganharia de Software', 'O mais sinistro do universo, sei todas linguagens');

INSERT INTO applicants (name, age, email, cpf, state, cep, education, description)
VALUES  ('Carl Jung', 74, 'carl@mail.com', '555.555.555-55', 'Espírito Santo', '55555-555', 'Doutor em Arquitetura de software', 'Sei até dos pensamentos das IAs, nem ela consegue passar por mim sem eu saber o que ela vai fazer');

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (1, 'Java'),
        (1, 'JavaScript'),
        (1, 'Spring');

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (2, 'Python'),
        (2, 'JavaScript'),
        (2, 'React');

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (3, 'Java'),
        (3, 'Groovy'),
        (3, 'TypeScript');

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (4, 'Java'),
        (4, 'Groovy'),
        (4, 'Angular'),
        (4, 'JavaScript'),
        (4, 'TypeScript');

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (5, 'Java'),
        (5, 'Groovy'),
        (5, 'Spring'),
        (5, 'Angular'),
        (5, 'React'),
        (5, 'Node'),
        (5, 'JavaScript'),
        (5, 'TypeScript');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Log Company', 'contato@logcompany.com', '44.444.444/0004-44', 'Sao Paulo', '44444-444', 'Levando seus pedidos a qualquer lugar do universo!');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Jutsu Academy', 'contato@jutsu.com', '55.555.555/0005-55', 'Rio de Janeiro', '55555-555', 'Elevando seu justu a outro nível, acredite em seu potencial');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Philosophy Library', 'contato@philosophy.com', '66.666.666/0006-66', 'Goiás', '66666-666', 'Study philophy and your life will be better than you could imagine. ');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Tech Solutions Bit', 'contato@techbit.com', '77.777.777/0007-77', 'São Paulo', '77777-777', 'Consultoria para elevar sua empresa para outro patamar.');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('ZG Marketing', 'contato@zgmkt.com', '88.888.888/0008-88', 'Goiás', '88888-888', 'Cuidamos do seu marketing como se fosse nosso. Talvez ele realmente seja...');

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('Dev Junior', 'Não é necessário experiência prévia', 1);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('Dev Estagiário', 'Conhecimento em Lógica de Programação e POO', 1);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('Dev Pleno', 'Necessário experiência prévia de 3 anos em Java e JavaScript', 2);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('Tech Lead', 'Gerenciamento de euipe comprovada, liderança e comunicação', 3);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('CTO', 'Atuação previa como CTO é desejável', 3);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('UX/UI Designer', 'COnhecimentos em figma, zeplin e jornada do usuário', 4);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('Tech Recruiter', 'Seleção de candidatos, preferencialmente com conhecimentos em desenvolvimento', 4);

INSERT INTO job_vacancies (job_title, job_description, company_id)
VALUES  ('DEV Web', 'Construção e manutenção de páginas web', 5);

INSERT INTO job_Vacancy_skills (job_vacancy_id, skill_id)
VALUES  (1, 'Java'),
        (1, 'JavaScript'),
        (2, 'Java'),
        (3, 'Python'),
        (3, 'React'),
        (4, 'Java'),
        (4, 'Angular'),
        (4, 'Groovy'),
        (5, 'Python'),
        (5, 'Java'),
        (5, 'Node'),
        (6, 'JavaScript'),
        (6, 'Typescript'),
        (7, 'Angular'),
        (8, 'JavaScript'),
        (8, 'Angular'),
        (8, 'TypeScript');

INSERT INTO applicant_job_vacancy (applicant_id, job_vacancy_id)
VALUES  (1, 1),
        (1, 2);

INSERT INTO applicant_job_vacancy (applicant_id, job_vacancy_id)
VALUES  (2, 1),
        (2, 3);

INSERT INTO applicant_job_vacancy (applicant_id, job_vacancy_id)
VALUES  (3, 2),
        (3, 4),
        (3, 6),
        (3, 8);

INSERT INTO applicant_job_vacancy (applicant_id, job_vacancy_id)
VALUES  (4, 4),
        (4, 7),
        (4, 8);

INSERT INTO applicant_job_vacancy (applicant_id, job_vacancy_id)
VALUES  (5, 5);