package com.acelerazg.test

import com.acelerazg.controller.ApplicantController
import com.acelerazg.controller.BusinessController
import com.acelerazg.enums.Skill
import com.acelerazg.model.Applicant
import com.acelerazg.model.Business
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertTrue

class BusinessTest {

    private BusinessController businessControl
    private Business businessTest

    @BeforeEach
    void testSetBusiness() {

        businessControl = new BusinessController()

        businessTest = new Business("Guod", "guod@contato.com.br", "12.365.325/0001-85",
        "Parana", "brasil", "00000-000", "mais uma description",
        [Skill.JAVA,Skill.ANGULAR,Skill.JAVASCRIPT])

    }

    @Test
    void testRegisterBusiness() {

        businessControl.registerCompany(businessTest)

        assertTrue(businessControl.getCompanies().contains(businessTest))

    }

    @Test
    void testBusinessName() {

        assertEquals("Guod", businessTest.name)
    }

    @Test
    void testBusinessSkills() {

        assertEquals([Skill.JAVA, Skill.ANGULAR, Skill.JAVASCRIPT,], businessTest.getSkills())

    }
}
