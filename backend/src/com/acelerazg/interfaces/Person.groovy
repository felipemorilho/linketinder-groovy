package com.acelerazg.interfaces

import com.acelerazg.enums.Skill

trait Person {

    String name
    String email
    String state
    String cep
    String description
    Skills skillsTrait

    String getName() { name }
    String getEmail() { email }
    String getDescription() { description }
    List<Skill> getSkills() { skillsTrait?.getSkills() ?: [] }

}