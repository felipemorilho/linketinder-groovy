package com.acelerazg.controller

import com.acelerazg.model.Applicant
import com.acelerazg.model.Vacancy

class AffinityController {

    static affinitySkills(List<Applicant> applicant, List<Vacancy> vacancy) {

        boolean hasAffinity = false

        applicant.each {applicants ->

            vacancy.each { vacancies ->

                if(applicants.getSkills().containsAll(vacancies.getSkills())) {

                    println("""\n\u001B[34m Afinidade encontrada!!
                Nome do candidato: ${applicants.name}, Email: ${applicants.email}
                Nome da empresa: ${vacancies.jobTitle}
                \u001B[0m""")

                    hasAffinity = true

                }
            }
        }

        if (!hasAffinity) {

            println("\n\u001B[31m Não há, no momento, match entre candidatos e vagas!!!\u001B[0m")

        }
    }
}
