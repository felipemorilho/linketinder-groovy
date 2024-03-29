package com.acelerazg.services


import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant

class ApplicantService {

    static Applicant saveApplicant(String[] registerApplicantData) {

        try {

            String name = registerApplicantData[0]
            String email = registerApplicantData[1]
            String state = registerApplicantData[2]
            String cep = registerApplicantData[3]
            String cpf = registerApplicantData[4]
            int age = registerApplicantData[5].toInteger()
            String education = registerApplicantData[6]
            String description = registerApplicantData[7]

            String skillsString = registerApplicantData[8].replaceAll("[\\[\\]]", '')
            List<Skill> skills = skillsString.tokenize(',').collect { Skill.valueOf(it.trim()) }

            return new Applicant(name, email, state, cep, cpf, age, education, description, skills)

        } catch (Exception ignore) {

            println("Erro ao salvar dados do candidato")
            return null
        }

    }
}