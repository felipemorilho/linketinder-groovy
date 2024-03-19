package com.acelerazg.model

import com.acelerazg.controller.SkillController
import com.acelerazg.enums.Skill
import com.acelerazg.interfaces.Skills

class Vacancy {

    String jobTitle
    String jobDescription
    int businessId
    Skills skillsTrait

    Vacancy(String jobTitle, String jobDescription, int businessId, List<Skill> skills) {

        this.jobTitle = jobTitle
        this.jobDescription = jobDescription
        this.businessId = businessId
        this.skillsTrait = new SkillController(skills)
    }

    List<Skill> getSkills() { skillsTrait?.getSkills() ?: [] }


}
