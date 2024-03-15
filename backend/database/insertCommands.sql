INSERT INTO skills (name)
VALUES  ('Java'),
        ('Python'),
        ('Groovy'),
        ('Spring'),
        ('JavaScript'),
        ('TypeScript'),
        ('Node'),
        ('Angular'),
        ('React');

-- SELECT * FROM skills;

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
VALUES  (1, 1),
        (1, 5),
        (1, 4);

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (2, 2),
        (2, 5),
        (2, 9);

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (3, 1),
        (3, 3),
        (3, 6);

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (4, 1),
        (4, 3),
        (4, 8),
        (4, 5),
        (4, 6);

INSERT INTO applicant_skills (applicant_id, skill_id)
VALUES  (5, 1),
        (5, 3),
        (5, 4),
        (5, 8),
        (5, 9),
        (5, 7),
        (5, 5),
        (5, 6);

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Log Company', 'contato@logcompany.com', '44.444.444/0004-44', 'Brasil', 'Sao Paulo', '44444-444', 'Levando seus pedidos a qualquer lugar do universo!');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Jutsu Academy', 'contato@jutsu.com', '55.555.555/0005-55', 'Rio de Janeiro', 'Brasil', '55555-555', 'Elevando seu justu a outro nível, acredite em seu potencial');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Philosophy Library', 'contato@philosophy.com', '66.666.666/0006-66', 'Goiás', 'Brasil', '66666-666', 'Study philophy and your life will be better than you could imagine. ');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('Tech Solutions Bit', 'contato@techbit.com', '77.777.777/0007-77', 'São Paulo', 'Brasil', '77777-777', 'Consultoria para elevar sua empresa para outro patamar.');

INSERT INTO companies (name, email, cnpj, state, country, cep, description)
VALUES ('ZG Marketing', 'contato@zgmkt.com', '88.888.888/0008-88', 'Goiás', '88888-888', 'Brasil', 'Cuidamos do seu marketing como se fosse nosso. Talvez ele realmente seja...');

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
VALUES  (1, 1),
        (1, 5),
        (2, 1),
        (3, 2),
        (3, 9),
        (4, 1),
        (4, 8),
        (4, 3),
        (5, 2),
        (5, 1),
        (5, 7),
        (6, 5),
        (6, 6),
        (7, 8),
        (8, 5),
        (8, 8),
        (8, 6);

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

-- SELECT * FROM applicant_job_vacancy;

-- SELECT * FROM applicants;

-- SELECT * FROM companies;

/*SELECT
    a.id AS applicant_id,
    a.name AS applicant_name,
    string_agg(jv.job_title, ', ') AS Vacancies_Aplied
FROM
    applicants a
        JOIN
    applicant_job_vacancy ajv ON a.id = ajv.applicant_id
        JOIN
    job_vacancies jv ON ajv.job_vacancy_id = jv.id
GROUP BY
    a.id, a.name;*/
