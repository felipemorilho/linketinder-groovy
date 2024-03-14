package com.acelerazg.test

import com.acelerazg.controller.ApplicantController
import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant
import groovy.test.GroovyTestCase
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertTrue

class ApplicantTest{

    static private ApplicantController applicantControl
    static private Applicant applicantTest

    @BeforeAll
    static void testSetApplicant() {

        applicantControl = new ApplicantController()

        applicantTest = new Applicant("Teste", "teste@teste.com.br",
                "STest", "00000-000", "000.000.000-00", 12, "Test decription. It should work",
                [Skill.PYTHON, Skill.JAVA, Skill.SPRING_FRAMEWORK])

    }

    @Test
    void testRegisterApplicant() {

        applicantControl.registerApplicant(applicantTest)

        assertTrue(applicantControl.getApplicants().contains(applicantTest))

    }

    @Test
    void testApplicantName() {

        assertEquals("Teste", applicantTest.name)

    }

    @Test
    void testApplicantSkills() {

        assertEquals([Skill.PYTHON, Skill.JAVA, Skill.SPRING_FRAMEWORK], applicantTest.getSkills())

    }
}
