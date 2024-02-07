package com.acelerazg.view


import com.acelerazg.model.ApplicantModel
import com.acelerazg.model.CompanyModel

class SystemView {

    static showApplicant (List<ApplicantModel> users) {
        users.each {person ->
            println("Nome: ${person.getName()}, " +
                    "Idade: ${person.age}, " +
                    "CPF: ${person.cpf}, " +
                    "Email: ${person.getEmail()}, " +
                    "Estado: ${person.state}, " +
                    "CEP: ${person.cep}, " +
                    "Descrição: ${person.description}, " +
                    "Competencias: ${person.getSkills()}")
        }
    }

    static showCompany (List<CompanyModel> companies) {
        companies.each {company ->
            println("Nome: ${company.name}, " +
                    "CNPJ: ${company.cnpj}, " +
                    "Email: ${company.email}, " +
                    "Estado: ${company.state}, " +
                    "País: ${company.country}, " +
                    "CEP: ${company.cep}, " +
                    "Descrição: ${company.description}, " +
                    "Competencias: ${company.getSkills()}")
        }
    }
}
