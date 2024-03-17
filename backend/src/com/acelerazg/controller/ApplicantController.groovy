package com.acelerazg.controller

import com.acelerazg.dao.ApplicantDAO
import com.acelerazg.model.Applicant

class ApplicantController {

    static private ApplicantDAO applicantDAO = new ApplicantDAO()

//    List<Applicant> applicants = []

    static void registerApplicant(Applicant applicant) {

        applicantDAO.insertApplicant(applicant)

    }

    List<Applicant> listApplicants() {

        applicants

    }

}
