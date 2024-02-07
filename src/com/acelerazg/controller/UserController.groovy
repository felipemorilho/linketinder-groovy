package com.acelerazg.controller

import com.acelerazg.interfaces.Person
import com.acelerazg.model.ApplicantModel
import com.acelerazg.model.CompanyModel

class UserController {

    List<ApplicantModel> applicants = []
    List<CompanyModel> companies = []

    void registerApplicant(ApplicantModel applicant) {
        applicants.add(applicant)
        println("${applicant.getName()}, seu cadastro foi efetuado!")
    }

    void registerCompany(CompanyModel company) {
        companies.add(company)
        println("${company.getName()}, seu cadastro foi efetuado!")
    }

    List<ApplicantModel> listApplicants() {
        applicants
    }

    List<CompanyModel> listCompanies() {
        companies
    }
}
