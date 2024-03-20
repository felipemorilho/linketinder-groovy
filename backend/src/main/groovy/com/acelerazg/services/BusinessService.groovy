package com.acelerazg.services


import com.acelerazg.model.Business

class BusinessService {

    static saveBusiness(String[] registerBusinessData) {

        try {

            String name = registerBusinessData[0]
            String email = registerBusinessData[1]
            String cnpj = registerBusinessData[2]
            String state = registerBusinessData[3]
            String country = registerBusinessData[4]
            String cep = registerBusinessData[5]
            String description = registerBusinessData[6]

            return new Business(name, email, cnpj, state, country, cep, description)

        } catch (Exception ignore) {

            println("Erro ao salvar dados da empresa")
            return null
        }
    }
}