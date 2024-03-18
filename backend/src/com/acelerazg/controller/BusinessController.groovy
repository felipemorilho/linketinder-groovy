package com.acelerazg.controller

import com.acelerazg.dao.BusinessDAO
import com.acelerazg.model.Business

class BusinessController {

    static private BusinessDAO businessDAO = new BusinessDAO()
//    List<Business> companies = []

    static void registerBusiness(Business business) {

        businessDAO.insertBusiness(business)

    }

    static List<Business> listBusiness() {

        List<Business> businesses = businessDAO.readBusiness()

        return businesses

    }
}
