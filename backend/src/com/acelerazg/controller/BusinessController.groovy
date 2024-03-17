package com.acelerazg.controller

import com.acelerazg.dao.BusinessDAO
import com.acelerazg.model.Business

class BusinessController {

    static private BusinessDAO businessDAO = new BusinessDAO()
//    List<Business> companies = []

    static void registerBusiness(Business business) {

        businessDAO.insertBusiness(business)

    }

    List<Business> listCompanies() {

        companies

    }
}
