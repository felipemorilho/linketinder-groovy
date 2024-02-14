package com.acelerazg.view

import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant

class ApplicantView {

    Scanner scan = new Scanner(System.in)

    Applicant showApplicantRegistration () {

        println("\u001b[34m Cadastro de Candidato \u001B[0m")

        print("Digite o nome: ")
        String name = scan.nextLine()

        print("Digite o email: ")
        String email = scan.nextLine()

        print("Digite o estado em que reside: ")
        String state = scan.nextLine()

        print("Digite seu CEP (Ex: 00000-000): ")
        String cep = scan.nextLine()

        print("Digite seu CPF (Ex: 000.000.000-00): ")
        String cpf = scan.nextLine()

        print("Digite a idade: ")
        String age = scan.nextLine()

        print("Aqui, faça uma descrição sobre você: ")
        String description = scan.nextLine()

        def skills = []

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

        return new Applicant(name, email, state, cep, cpf, age.toInteger(), description, skills)

    }

    static showApplicant (List<Applicant> users) {

        users.each { person ->

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
}
