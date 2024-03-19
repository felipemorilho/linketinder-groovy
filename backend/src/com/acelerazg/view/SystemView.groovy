package com.acelerazg.view

import com.acelerazg.controller.AffinityController
import com.acelerazg.controller.ApplicantController
import com.acelerazg.controller.BusinessController
import com.acelerazg.controller.VacancyController
import com.acelerazg.model.Applicant
import com.acelerazg.model.Business
import com.acelerazg.model.Vacancy
import com.acelerazg.services.ApplicantService
import com.acelerazg.services.BusinessService
import com.acelerazg.services.VacancyService

class SystemView {

    static ApplicantController controlApplicant = new ApplicantController()
    static BusinessController controlBusiness = new BusinessController()
    static VacancyController vacancyController = new VacancyController()
    static AffinityController controlMatch = new AffinityController()

    static ApplicantView applicantView = new ApplicantView()
    static BusinessView businessView = new BusinessView()
    static VacancyView vacancyView = new VacancyView()

    static ApplicantService applicantService = new ApplicantService()
    static BusinessService businessService = new BusinessService()
    static VacancyService vacancyService = new VacancyService()

    static Scanner scan = new Scanner(System.in)

    static String showMenu() {


        print('''\u001B[32m\nSeja bem-vindo ao LinkeTinder!!! \u001B[0m

Escolha a opção desejada:

1 - Menu Candidato
2 - Menu Empresa
3 - Verificar se há afinidade entre candidato/empresa
0 - Sair

\u001B[33mDigite a opção desejada: \u001B[0m''')

        String option = scan.nextLine()
        return option

    }

    static String showMenuApplicant() {


        print('''\u001B[32m\n Candidato: \u001B[0m

Escolha a opção desejada:

1 - Cadastro Candidato
2 - Atualizar Candidato
3 - Aplicar à Vaga
4 - Listar Candidatos
5 - Listar Vagas
6 - Deletar Candidato
0 - Sair

\u001B[33mDigite a opção desejada: \u001B[0m''')

        String option = scan.nextLine()

        return option

    }

    static String showMenuBusiness() {

        print('''\u001B[32m\n Empresa: \u001B[0m

Escolha a opção desejada:

1 - Cadastro Empresa
2 - Atualizar Empresa
3 - Cadastro de Vaga
4 - Atualizar Vaga
5 - Listar Empresas
6 - Listar Vagas
7 - Deletar Empresa
8 - Deletar Vaga
0 - Sair

\u001B[33mDigite a opção desejada: \u001B[0m''')

        String option = scan.nextLine()

        return option

    }

    static selectMenu(String option) {

        while(true) {

            switch(option) {

                case "1":

                    String optionApplicant = showMenuApplicant()
                    selectOptionApplicant(optionApplicant)
                    return

                case "2":

                    String optionBusiness = showMenuBusiness()
                    selectOptionBusiness(optionBusiness)
                    return

                case "3":

                    controlMatch.affinitySkills(controlApplicant.listApplicants(), vacancyController.listVacancies())
                    return

                case "0":

                    println("Muito obrigado pela visita!!!")
                    System.exit(0)
                    return

                default:

                    println("Opção inválida! Por favor, digite uma opção válida.")
                    return

            }
        }
    }

    static selectOptionApplicant(String option) {

        while (true) {

            switch (option) {

                case "1":

                    String[] registerApplicantData = applicantView.showApplicantRegistration()
                    Applicant newApplicant = applicantService.saveApplicant(registerApplicantData)
                    controlApplicant.registerApplicant(newApplicant)
                    return

                case "2":

                    String cpf = informData()
                    String[] registerApplicantData = applicantView.showApplicantRegistration()
                    Applicant updatedApplicant = applicantService.saveApplicant(registerApplicantData)
                    controlApplicant.updateApplicant(cpf, updatedApplicant)
                    return

                case "3":

                    String cpf = informData()
                    int vacancyId = informId() as int
                    controlApplicant.applicantJobApply(cpf, vacancyId)
                    return

                case "4":

                    applicantView.showApplicant(controlApplicant.listApplicants())
                    return

                case "5":

                    vacancyView.showVacancy(vacancyController.listVacancies())
                    return

                case "6":

                    String cpf = informData()
                    controlApplicant.deleteApplicant(cpf)
                    return

                case "0":

                    return

                default:

                    println("Opção inválida! Por favor, digite uma opção válida.")
                    return

            }
        }
    }

    static selectOptionBusiness(String option) {

        while (true) {

            switch (option) {

                case "1":

                    String[] registerBusinessData = businessView.showBusinessRegistration()
                    Business newBusiness = businessService.saveBusiness(registerBusinessData)
                    controlBusiness.registerBusiness(newBusiness)
                    return

                case "2":

                    String cnpj = informData()
                    String[] registerBusinessData = businessView.showBusinessRegistration()
                    Business updatedBusiness = businessService.saveBusiness(registerBusinessData)
                    controlBusiness.updateBusiness(cnpj, updatedBusiness)
                    return

                case "3":

                    String[] registerVacancyData = vacancyView.showVacancyRegistration()
                    Vacancy newVacancy = vacancyService.saveVacancy(registerVacancyData)
                    vacancyController.registerVacancy(newVacancy)
                    return

                case "4":

                    int vacancyId = informId() as int
                    String[] updateVacancyData = vacancyView.showVacancyRegistration()
                    Vacancy updateVacancy = vacancyService.saveVacancy(updateVacancyData)
                    vacancyController.updateVacancy(vacancyId, updateVacancy)
                    return

                case "5":

                    businessView.showCompany(controlBusiness.listBusiness())
                    return

                case "6":

                    vacancyView.showVacancy(vacancyController.listVacancies())
                    return

                case "7":

                    String cnpj = informData()
                    controlBusiness.deleteBusiness(cnpj)
                    return

                case "8":

                    int id = informId() as int
                    vacancyController.deleteVacancy(id)
                    return

                case "0":

                    return

                default:

                    println("Opção inválida! Por favor, digite uma opção válida.")
                    return

            }
        }
    }

    static String informData() {

        print("Informe o cpf/cnpj: ")
        String data = scan.nextLine()

        return data
    }

    static String informId() {

        print("Informe o id: ")
        String id = scan.nextLine()

        return id
    }
}
