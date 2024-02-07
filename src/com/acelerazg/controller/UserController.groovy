package com.acelerazg.controller

import com.acelerazg.enums.Skill
import com.acelerazg.model.ApplicantModel
import com.acelerazg.model.CompanyModel

class UserController {

    List<ApplicantModel> applicants = []
    List<CompanyModel> companies = []
    def scan = new Scanner(System.in)


    void registerApplicant(ApplicantModel applicant) {
        applicants.add(applicant)
        println("${applicant.getName()}, seu cadastro foi efetuado!")
    }

    void registerCompany(CompanyModel company) {
        companies.add(company)
        println("${company.getName()}, seu cadastro foi efetuado!")
    }

    ApplicantModel manualRegister() {
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
        int age = scan.nextInt()

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

        def newApplicant = new ApplicantModel(name, email, state, cep, cpf, age, description, skills)
    }

    List<ApplicantModel> listApplicants() {
        applicants
    }

    List<CompanyModel> listCompanies() {
        companies
    }
}
