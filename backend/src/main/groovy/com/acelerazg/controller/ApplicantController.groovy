package com.acelerazg.controller

import com.acelerazg.dao.ApplicantDAO
import com.acelerazg.model.Applicant

class ApplicantController {

    static private ApplicantDAO applicantDAO = new ApplicantDAO()

    static void registerApplicant(Applicant applicant) {

        applicantDAO.insertApplicant(applicant)

    }

    static void applicantJobApply(String cpf, int id) {

        applicantDAO.insertApplicantJobVacancy(cpf, id)

    }

    static List<Applicant> listApplicants() {

        List<Applicant> applicants = applicantDAO.readApplicants()

        if(!applicants.isEmpty()) {

            return applicants

        }

        println("Não há candidatos para exibir.")

        return null
    }

    static void updateApplicant(String cpf, Applicant applicant) {

        applicantDAO.updateApplicant(cpf, applicant)

    }

    static void deleteApplicant(String cpf) {

        applicantDAO.deleteApplicant(cpf)
    }



}
