package com.acelerazg.model

import com.acelerazg.controller.SkillController
import com.acelerazg.enums.Skill
import com.acelerazg.interfaces.Person

class CompanyModel implements Person {

    String cnpj
    String country

    CompanyModel(String name, String email, String cnpj, String state, String country, String cep, String description, List<Skill> skills) {
        this.name = name
        this.email = email
        this.cnpj = cnpj
        this.state = state
        this.country = country
        this.cep = cep
        this.description = description
        this.skillsTrait = new SkillController(skills)
    }
}
