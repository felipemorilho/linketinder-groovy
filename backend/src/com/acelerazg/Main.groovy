//Felipe Morilho de Castro
package com.acelerazg

import com.acelerazg.controller.AffinityController
import com.acelerazg.controller.ApplicantController
import com.acelerazg.controller.BusinessController
import com.acelerazg.controller.VacancyController
import com.acelerazg.model.Business
import com.acelerazg.services.ApplicantService
import com.acelerazg.services.BusinessService
import com.acelerazg.services.VacancyService
import com.acelerazg.view.ApplicantView
import com.acelerazg.view.BusinessView
import com.acelerazg.view.SystemView
import com.acelerazg.view.VacancyView

ApplicantController controlApplicant = new ApplicantController()
BusinessController controlBusiness = new BusinessController()
VacancyController vacancyController = new VacancyController()
ApplicantView applicantView = new ApplicantView()
BusinessView businessView = new BusinessView()
VacancyView vacancyView = new VacancyView()
AffinityController controlMatch = new AffinityController()
ApplicantService applicantService = new ApplicantService()
BusinessService businessService = new BusinessService()
VacancyService vacancyService = new VacancyService()
SystemView systemView = new SystemView()


//Applicant a1 = new Applicant("Pedro", "pedroa@gmail.com", "São Paulo", "11090-080", "123.456.789-00", 32, "Superior Completo", "Dev Junior", [Skill.PYTHON, Skill.ANGULAR])
//Applicant a2 = new Applicant("Rafaela", "rafa.eu@gmail.com", "Minas Gerais", "39190-980", "123.123.456-99", 21, "Cursando ADS", "Buscando Estágio", [Skill.JAVASCRIPT, Skill.TYPESCRIPT, Skill.JAVA])
//Applicant a3 = new Applicant("Carlos", "rcarlos@gmail.com", "Goias", "62520-980", "352.154.852-98", 52, "Engenheiro da Compuração", "Dev Pleno", [Skill.JAVASCRIPT, Skill.ANGULAR, Skill.JAVA])
//Applicant a4 = new Applicant("Juliana", "jujugmail.com", "Bahia", "78450-980", "745.852.369-25", 24, "Cientista de dados", "Dev Senior", [Skill.JAVASCRIPT, Skill.SPRING_FRAMEWORK, Skill.JAVA])
//Applicant a5 = new Applicant("Lucas", "lucas@gmail.com", "Espírito Santo", "29560-980", "123.741.258-99", 31, "Pós Graduado em Engenharia de Software", "Tech Lead", [Skill.JAVASCRIPT])

//Business c1 = new Business("Jururu", "contato@jururu.com.br", "12.589.369/0001-89", "São Paulo", "Brasil","11089-090", "Consultoria em Tecnologia")
//Business c2 = new Business("Belami", "contato@belami.com.br", "85.321.753/0004-52", "Paraná", "Brasil", "49008-065", "Desenvolvimento de Sites")
//Business c3 = new Business("LogNation", "contato@log.com.br", "02.584.789/0004-98", "Santa Catarina", "Brasil", "84000-580", "Desenvolvimento de Softwares")
//Business c4 = new Business("Telecom", "contato@telecom.com.br", "32.025.145/0001-52", "Rio de Janeiro", "Brasil", "21250-850", "Sistemas ERP")
//Business c5 = new Business("EngTec", "contato@engtec.com.br", "41.154.753/0001-56", "Espírito Santo", "Brasil", "29010-470", "Desenvolvimento de  Ecommerce")

//controlApplicant.registerApplicant(a1)
//controlApplicant.registerApplicant(a2)
//controlApplicant.registerApplicant(a3)
//controlApplicant.registerApplicant(a4)
//controlApplicant.registerApplicant(a5)
//controlBusiness.registerBusiness(c1)
//controlBusiness.registerBusiness(c2)
//controlBusiness.registerBusiness(c3)
//controlBusiness.registerBusiness(c4)
//controlBusiness.registerBusiness(c5)


while (true) {

    String option = systemView.showMenu()

    switch (option) {

        case "1":

            String[] registerApplicantData = applicantView.showApplicantRegistration()
            controlApplicant.registerApplicant(applicantService.saveApplicant(registerApplicantData))
            break

        case "2":

            String[] registerBusinessData = businessView.showBusinessRegistration()
            controlBusiness.registerBusiness(businessService.saveBusiness(registerBusinessData))
            break

        case "3":

            String[] registerVacancyData = vacancyView.showVacancyRegistration()
            vacancyController.registerVacancy(vacancyService.saveVacancy(registerVacancyData))
            break

        case "4":

            applicantView.showApplicant(controlApplicant.listApplicants())
            break

        case "5":

            businessView.showCompany(controlBusiness.listCompanies())
            break

        case "6":

            controlMatch.affinitySkills(controlApplicant.listApplicants(), controlBusiness.listCompanies())
            break

        case "0":

            println("Muito obrigado pela visita!!!")
            System.exit(0)
            break

        default:

            println("Opção inválida! Por favor, digite uma opção válida.")

    }
}
