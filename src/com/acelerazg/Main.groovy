package com.acelerazg

import com.acelerazg.controller.UserController
import com.acelerazg.enums.Skill
import com.acelerazg.model.ApplicantModel
import com.acelerazg.model.CompanyModel
import com.acelerazg.view.SystemView

def control = new UserController()
def systemView = new SystemView()
def scan = new Scanner(System.in)

def a1 = new ApplicantModel("Pedro", "pedroa@gmail.com", "São Paulo", "11090-080", "123.456.789-00", 32, "Dev Junior", [Skill.PYTHON, Skill.ANGULAR])
def a2 = new ApplicantModel("Rafaela", "rafa.eu@gmail.com", "Minas Gerais", "39190-980", "123.123.456-99", 21, "Buscando Estágio", [Skill.JAVASCRIPT, Skill.TYPESCRIPT, Skill.JAVA])
def a3 = new ApplicantModel("Carlos", "rcarlos@gmail.com", "Goias", "62520-980", "352.154.852-98", 52, "Dev Pleno", [Skill.JAVASCRIPT, Skill.ANGULAR, Skill.JAVA])
def a4 = new ApplicantModel("Juliana", "jujugmail.com", "Bahia", "78450-980", "745.852.369-25", 24, "Dev Senior", [Skill.JAVASCRIPT, Skill.SPRING_FRAMEWORK, Skill.JAVA])
def a5 = new ApplicantModel("Lucas", "lucas@gmail.com", "Espírito Santo", "29560-980", "123.741.258-99", 31, "Tech Lead", [Skill.JAVASCRIPT])
def c1 = new CompanyModel("Jururu", "contato@jururu.com.br", "12.589.369/0001-89", "São Paulo", "Brasil","11089-090", "Consultoria em Tecnologia", [Skill.JAVA, Skill.ANGULAR])
def c2 = new CompanyModel("Belami", "contato@belami.com.br", "85.321.753/0004-52", "Paraná", "Brasil", "49008-065", "Desenvolvimento de Sites", [Skill.JAVASCRIPT, Skill.ANGULAR, Skill.TYPESCRIPT])
def c3 = new CompanyModel("LogNation", "contato@log.com.br", "02.584.789/0004-98", "Santa Catarina", "Brasil", "84000-580", "Desenvolvimento de Softwares", [Skill.JAVASCRIPT, Skill.SPRING_FRAMEWORK, Skill.TYPESCRIPT])
def c4 = new CompanyModel("Telecom", "contato@telecom.com.br", "32.025.145/0001-52", "Rio de Janeiro", "Brasil", "21250-850", "Sistemas ERP", [Skill.JAVASCRIPT, Skill.PYTHON])
def c5 = new CompanyModel("EngTec", "contato@engtec.com.br", "41.154.753/0001-56", "Espírito Santo", "Brasil", "29010-470", "Desenvolvimento de  Ecommerce", [Skill.GROOVY, Skill.JAVA])

control.registerApplicant(a1)
control.registerApplicant(a2)
control.registerApplicant(a3)
control.registerApplicant(a4)
control.registerApplicant(a5)
control.registerCompany(c1)
control.registerCompany(c2)
control.registerCompany(c3)
control.registerCompany(c4)
control.registerCompany(c5)


while (true) {
    print('''\u001B[32m\nSeja bem-vindo ao LinkeTinder!!! \u001B[0m

Escolha a opção desejada:

1 - Cadastro Candidato
2 - Cadastro Empresa
3 - Listar Candidatos
4 - Listar Empresas
5 - Verificar se há match entre candidato/empresa
0 - Sair

\u001B[33mDigite a opção desejada: \u001B[0m''')

    def option = scan.nextLine()
    switch (option) {
        case "1":
            control.registerApplicant(control.manualRegisterApplicant())
            break
        case "2":
            control.registerCompany(control.manualRegisterCompany())
            break
        case "3":
            systemView.showApplicant(control.listApplicants())
            break
        case "4":
            systemView.showCompany(control.listCompanies())
            break
        case "5":
            control.matchSkills()
            break
        case "0":
            println("Muito obrigado pela visita!!!")
            System.exit(0)
            break
        default:
            println("Opção inválida! Por favor, digite uma opção válida.")
    }
}
