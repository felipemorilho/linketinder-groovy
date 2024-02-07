package com.acelerazg.controller

import com.acelerazg.interfaces.Person

class UserController {

    List<Person> users = []

    void registerPerson(Person person) {
        users.add(person)
        println("${person.getClass().getSimpleName()} ${person.getName()} cadastrada com sucesso!")
    }

    List<Person> listUsers() {
        users
    }
}
