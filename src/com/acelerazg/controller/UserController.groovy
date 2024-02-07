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
    }

    void registerCompany(CompanyModel company) {
        companies.add(company)
    }

    ApplicantModel manualRegisterApplicant() {
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
        return new ApplicantModel(name, email, state, cep, cpf, age.toInteger(), description, skills)
    }

    CompanyModel manualRegisterCompany() {
        println("\u001b[34m Cadastro de Candidato \u001B[0m")

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
        return new CompanyModel(name, email, cnpj, state, country, cep, description, skills)
    }

    void matchSkills() {
        def applicantList = applicants.findAll { it instanceof ApplicantModel}
        def companyList = companies.findAll { it instanceof CompanyModel }

        boolean hasMatch = false
        applicantList.each {applicant ->
            companyList.each { company ->
                if(applicant.getSkills() == company.getSkills()) {
                    println("""\n\u001B[34mMatch encontrado!!
                Nome do candidato: ${applicant.name}, Email: ${applicant.email}
                Nome da empresa: ${company.name}, Email: ${company.email}
                \u001B[0m""")
                    hasMatch = true
                }
            }
        }
        if (!hasMatch) {
            println("\n\u001B[31mNão há, no momento, match entre candidatos e empresas!!!\u001B[0m")
        }
    }

    List<ApplicantModel> listApplicants() {
        applicants
    }

    List<CompanyModel> listCompanies() {
        companies
    }
}
