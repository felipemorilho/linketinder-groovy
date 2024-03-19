package com.acelerazg.view

import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant

class ApplicantView {

    Scanner scan = new Scanner(System.in)

    String[] showApplicantRegistration () {

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

        print("Digite a sua formação: ")
        String education = scan.nextLine()

        print("Aqui, faça uma descrição sobre você: ")
        String description = scan.nextLine()

        List<String> skills = []

        while (true) {

            println('''Escolha suas competências: 

            PYTHON, JAVA, SPRING, 
            ANGULAR, GROOVY, JAVASCRIPT,
            TYPESCRIPT, NODE OU REACT

            Digite "sair" para finalizar.
            ''')

            print("Digite a que deseja adicionar: ")
            String readSkill = scan.nextLine()

            if (readSkill.equalsIgnoreCase('sair')) {

                break

            }

            try {

                Skill skillName = Skill.valueOf(readSkill.toUpperCase())
                skills.add(skillName as String)

            } catch (IllegalArgumentException ignored) {

                println("Habilidade Inválida. Por favor, escolha uma da lista!")

            }
        }

        return [name, email, state, cep, cpf, age.toInteger(), education, description, skills]
    }

    static showApplicant (List<Applicant> applicants) {

        applicants.each { applicant ->

            println("Nome: ${applicant.name}, " +
                    "Idade: ${applicant.age}, " +
                    "CPF: ${applicant.cpf}, " +
                    "Email: ${applicant.email}, " +
                    "Estado: ${applicant.state}, " +
                    "CEP: ${applicant.cep}, " +
                    "Descrição: ${applicant.description}, " +
                    "Competencias: ${applicant.getSkills()}")

        }
    }
}
