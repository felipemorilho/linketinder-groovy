package com.acelerazg.view

import com.acelerazg.enums.Skill
import com.acelerazg.model.Business

class BusinessView {

    Scanner scan = new Scanner(System.in)

    Business manualRegister() {

        println("\u001b[34m Cadastro de Empresa \u001B[0m")

        print("Digite o nome: ")
        String name = scan.nextLine()

        print("Digite o email: ")
        String email = scan.nextLine()

        print("Digite seu CNPJ (Ex: 00.000.000/0000-00): ")
        String cnpj = scan.nextLine()

        print("Digite o estado em que reside: ")
        String state = scan.nextLine()

        print("Digite o país em que reside: ")
        String country = scan.nextLine()

        print("Digite seu CEP (Ex: 00000-000): ")
        String cep = scan.nextLine()

        print("Aqui, faça uma descrição sobre a empresa: ")
        String description = scan.nextLine()

        ArrayList<Skill> skills = []

        while (true) {

            println('''Escolha suas competências: 

            PYTHON, JAVA, SPRING_FRAMEWORK,
                    ANGULAR, GROOVY, JAVASCRIPT ou TYPESCRIPT

            Digite "sair" para finalizar.''')

            print("Digite a que deseja adicionar: ")
            String readSkill = scan.nextLine()

            if (readSkill.equalsIgnoreCase('sair')) {

                break

            }

            try {

                def skillName = Skill.valueOf(readSkill.toUpperCase())
                skills.add(skillName)

            } catch (IllegalArgumentException e) {

                println("Habilidade Inválida. Por favor, escolha uma da lista!")

            }

        }

        println("\n\u001B[36m${name}, seu cadastro foi efetuado!\u001B[0m")

        return new Business(name, email, cnpj, state, country, cep, description, skills)
    }

    static showCompany (List<Business> companies) {

        companies.each { company ->

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