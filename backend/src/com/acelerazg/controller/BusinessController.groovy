package com.acelerazg.controller

import com.acelerazg.dao.BusinessDAO
import com.acelerazg.model.Business

class BusinessController {

    static private BusinessDAO businessDAO = new BusinessDAO()

    static void registerBusiness(Business business) {

        businessDAO.insertBusiness(business)

    }

    static List<Business> listBusiness() {

        List<Business> businesses = businessDAO.readBusiness()

        if(!businesses.isEmpty()) {

            return businesses
        }

        println("Não há empresas para exibir.")

        return null
    }
}
