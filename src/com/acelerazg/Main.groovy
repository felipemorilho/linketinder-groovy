package com.acelerazg

import com.acelerazg.controller.UserController
import com.acelerazg.enums.Skill
import com.acelerazg.model.ApplicantModel
import com.acelerazg.model.CompanyModel
import com.acelerazg.view.SystemView

def control = new UserController()
def systemView = new SystemView()
def scan = new Scanner(System.in)

def a1 = new ApplicantModel("Pedro", "pedroa@gmail.com", "São Paulo", "11090-080", "12345678900", 32, "Dev Junior", [Skill.PYTHON, Skill.ANGULAR])
def a2 = new ApplicantModel("Rafaela", "rafa.eu@gmail.com", "Minas Gerais", "39190-980", "12312345699", 21, "Buscando Estágio", [Skill.JAVASCRIPT, Skill.TYPESCRIPT, Skill.JAVA])
def c1 = new CompanyModel("Jururu", "contato@jururu.com.br", "12589369000189", "São Paulo", "Brasil","11089-090", "Consultoria em Tecnologia", [Skill.JAVA, Skill.ANGULAR])
def c2 = new CompanyModel("Belami", "contato@belami.com.br", "85321753000452", "Paraná", "Brasil", "49008-065", "Desenvolvimento de Sites", [Skill.JAVASCRIPT, Skill.ANGULAR, Skill.TYPESCRIPT])

control.registerApplicant(a1)
control.registerApplicant(a2)
control.registerCompany(c1)
control.registerCompany(c2)


while (true) {
    print('''\u001B[32mSeja bem-vindo ao LinkeTinder!!! \u001B[0m

Escolha a opção desejada:

1 - Cadastro Candidato (não disponível)
2 - Cadastro Empresa (não disponível)
3 - Listar Candidatos
4 - Listar Empresas
0 - Sair

\u001B[33mDigite a opção desejada:  \u001B[0m''')

    def option = scan.nextLine()
    switch (option) {
        case "1":
            break
        case "2":
            break
        case "3":
            systemView.showApplicant(control.listApplicants())
            break
        case "4":
            systemView.showCompany(control.listCompanies())
            break
        case "0":
            println("Muito obrigado pela visita!!!")
            System.exit(0)
            break
        default:
            println("Opção inválida! Por favor, digite uma opção válida.")
    }
}
