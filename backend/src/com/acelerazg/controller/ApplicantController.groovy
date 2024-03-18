package com.acelerazg.controller

import com.acelerazg.dao.ApplicantDAO
import com.acelerazg.model.Applicant

class ApplicantController {

    static private ApplicantDAO applicantDAO = new ApplicantDAO()

    static void registerApplicant(Applicant applicant) {

        applicantDAO.insertApplicant(applicant)

    }

    static List<Applicant> listApplicants() {

        List<Applicant> applicants = applicantDAO.readApplicants()

        return applicants

    }

}
