package com.acelerazg.model

import com.acelerazg.controller.SkillController
import com.acelerazg.enums.Skill
import com.acelerazg.interfaces.Person


class Applicant implements Person {
    String cpf
    int age
    String education

    Applicant(String name, String email, String state, String cep, String cpf, int age,String education, String description, List<Skill> skills) {
        this.name = name
        this.email = email
        this.state = state
        this.cep = cep
        this.cpf = cpf
        this.age = age
        this.education = education
        this.description = description
        this.skillsTrait = new SkillController(skills)
    }
}
