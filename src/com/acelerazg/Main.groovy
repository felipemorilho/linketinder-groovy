package com.acelerazg

import com.acelerazg.controller.UserController
import com.acelerazg.enums.Skill
import com.acelerazg.model.ApplicantModel
import com.acelerazg.model.CompanyModel
import com.acelerazg.view.SystemView

def control = new UserController()
def systemView = new SystemView()

def a1 = new ApplicantModel("Pedro", "pedroa@gmail.com", "São Paulo", "11090-080", "12345678900", 32, "Dev Junior", [Skill.PYTHON, Skill.ANGULAR])
def a2 = new ApplicantModel("Rafaela", "rafa.eu@gmail.com", "Minas Gerais", "39190-980", "12312345699", 21, "Buscando Estágio", [Skill.JAVASCRIPT, Skill.TYPESCRIPT, Skill.JAVA])
def c1 = new CompanyModel("Jururu", "contato@jururu.com.br", "12589369000189", "Brasil", "Consultoria em Tecnologia", [Skill.JAVA, Skill.ANGULAR])
def c2 = new CompanyModel("Belami", "contato@belami.com.br", "85321753000452", "Brasil", "Desenvolvimento de Sites", [Skill.JAVASCRIPT, Skill.ANGULAR, Skill.TYPESCRIPT])

control.registerPerson(a1)
control.registerPerson(a2)
control.registerPerson(c1)
control.registerPerson(c2)

systemView.showUsers(control.listUsers())

