package com.acelerazg.controller

import com.acelerazg.model.Applicant
import com.acelerazg.model.Business

class AffinityController {

    static affinitySkills(List<Applicant> applicant, List<Business> business) {

        boolean hasAffinity = false

        applicant.each {applicants ->

            business.each { company ->

                if(applicants.getSkills().containsAll(company.getSkills())) {

                    println("""\n\u001B[34mMatch encontrado!!
                Nome do candidato: ${applicants.name}, Email: ${applicants.email}
                Nome da empresa: ${company.name}, Email: ${company.email}
                \u001B[0m""")

                    hasAffinity = true

                }
            }
        }

        if (!hasAffinity) {

            println("\n\u001B[31mNão há, no momento, match entre candidatos e empresas!!!\u001B[0m")

        }
    }
}