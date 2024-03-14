package com.acelerazg.services

import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant
import com.acelerazg.model.Business

class BusinessService {

    static saveBusiness(String[] registerBusinessData) {

        String name = registerBusinessData[0]
        String email = registerBusinessData[1]
        String cnpj = registerBusinessData[2]
        String state = registerBusinessData[3]
        String country = registerBusinessData[4]
        String cep = registerBusinessData[5]
        String description = registerBusinessData[6]

        String skillsString = registerBusinessData[7].replaceAll("[\\[\\]]", '')
        List<Skill> skills = skillsString.tokenize(',').collect { Skill.valueOf(it.trim()) }

        return new Business(name, email, cnpj, state, country, cep, description, skills)
    }
}
