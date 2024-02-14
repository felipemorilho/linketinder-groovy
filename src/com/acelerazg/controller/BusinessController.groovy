package com.acelerazg.controller

import com.acelerazg.model.Business

class BusinessController {

    List<Business> companies = []

    void registerCompany(Business company) {

        companies.add(company)

    }

    List<Business> listCompanies() {

        companies

    }
}
