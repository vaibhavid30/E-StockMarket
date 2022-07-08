package com.estockmarket.stockmarket.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.stockmarket.model.Company;
import com.estockmarket.stockmarket.service.CompanyService;

@RestController
@CrossOrigin
@RequestMapping("market/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    // Company Reggistration
    @PostMapping("/register")
    public Company register(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    // Get all Companies
    @GetMapping("/info/{companyId}")
    public Company fetchCompanyDetails(@PathVariable(value = "companyId") UUID companyId) {
        return companyService.getCompanyById(companyId);
    }

    // Get Company details with Company ID
    @GetMapping("/getall")
    public List<Company> ListAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Delete Company with Company ID
    @DeleteMapping("/delete/{companyid}")
    public void deleteCompany(@PathVariable(value = "companyid") UUID companyid) {
         companyService.deleteCompany(companyid);
    }


    //Custom API's
    // List all companies registered by User
    @GetMapping("/fetchUserCompanies/{userId}")
    public List<Company> fetchUserCompanies(@PathVariable(value = "userId") UUID userId) {
        return companyService.getCompanyByUserId(userId);
    }
}
