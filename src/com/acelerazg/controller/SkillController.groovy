package com.acelerazg.controller

import com.acelerazg.enums.Skill
import com.acelerazg.interfaces.Skills

class SkillController implements Skills {

    List<Skill> skills

    SkillController(List<Skill> skills) {
        this.skills = skills
    }
}
