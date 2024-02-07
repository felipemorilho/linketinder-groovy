package com.acelerazg.view

import com.acelerazg.interfaces.Person

class SystemView {

    void showUsers (List<Person> users) {
        users.each {person ->
            println("Nome: ${person.getName()}, Email: ${person.getEmail()}, Competencias: ${person.getSkills()}")
        }
    }
}
