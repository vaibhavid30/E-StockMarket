package com.estockmarket.stockmarket.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.estockmarket.stockmarket.model.Company;
import com.estockmarket.stockmarket.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired(required = true)
	CompanyRepository companyRepository;

	@Autowired(required = true)
	StockService stockService;

	@Autowired(required = true)
	MultipleStockService multipleStockService;

	public Company saveCompany(@RequestBody Company company) {
		Company companySet = new Company();
		companySet.setCompanyCEO(company.getCompanyCEO());
		companySet.setCompanyName(company.getCompanyName());
		companySet.setCompanyStockExchange(company.getCompanyStockExchange());
		companySet.setCompanyTurnOver(company.getCompanyTurnOver());
		companySet.setCompanyWebsite(company.getCompanyWebsite());
		return companyRepository.save(companySet);
	}

	public Company getCompanyById(UUID companyId) {
		return companyRepository.findByCompanyID(companyId);
	}

	public void deleteCompany(UUID companyid) {
		
		 	stockService.deleteAllStock(companyid);
			companyRepository.deleteById(companyid);
	}

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

}
