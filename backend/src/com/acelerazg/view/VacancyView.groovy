package com.acelerazg.view

import com.acelerazg.enums.Skill

class VacancyView {

    Scanner scan = new Scanner(System.in)

    String[] showVacancyRegistration() {

        println("\u001b[34m Cadastro de Vaga: \u001B[0m")

        print("Digite o título da vaga: ")
        String jobTitle = scan.nextLine()

        print("Aqui, faça uma descrição sobre a vaga: ")
        String jobDescription = scan.nextLine()

        print("Digite o id da empresa: ")
        String businessId = scan.nextLine()

        List<Skill> skills = []

        while (true) {

            println('''Escolha as competências pertinentes à vaga: 

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

            } catch (IllegalArgumentException ignored) {

                println("Habilidade Inválida. Por favor, escolha uma da lista!")

            }
        }

        return [jobTitle, jobDescription, businessId.toInteger(), skills]
    }
}