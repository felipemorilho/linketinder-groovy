package com.acelerazg.controller


import com.acelerazg.model.Applicant

class ApplicantController {

    List<Applicant> applicants = []

    void registerApplicant(Applicant applicant) {

        applicants.add(applicant)

    }

    List<Applicant> listApplicants() {

        applicants

    }

}
