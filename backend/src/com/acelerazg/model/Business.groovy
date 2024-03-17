package com.acelerazg.model


import com.acelerazg.interfaces.Register

class Business implements Register {

    String cnpj
    String country

    Business(String name, String email, String cnpj, String state, String country, String cep, String description) {
        this.name = name
        this.email = email
        this.cnpj = cnpj
        this.state = state
        this.country = country
        this.cep = cep
        this.description = description
    }
}
