package com.estockmarket.stockmarket.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.estockmarket.stockmarket.model.Company;
import com.estockmarket.stockmarket.model.Stock;
import com.estockmarket.stockmarket.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired(required = true)
	CompanyRepository companyRepository;

	@Autowired(required = true)
	StockService stockService;

	public Company saveCompany(@RequestBody Company company) {
		Company companySet = new Company();
		companySet.setCompanyCEO(company.getCompanyCEO());
		companySet.setCompanyName(company.getCompanyName());
		companySet.setCompanyStockExchange(company.getCompanyStockExchange());
		companySet.setCompanyTurnOver(company.getCompanyTurnOver());
		companySet.setCompanyWebsite(company.getCompanyWebsite());
		companySet.setUserID(company.getUserID());
		return companyRepository.save(companySet);
	}

	public List<Company> getCompanyByUserId(UUID userid) {
		return companyRepository.findAllCompanyByuserID(userid);
	}

	public Company getCompanyById(UUID companyId) {
		return companyRepository.findByCompanyID(companyId);
	}

	public void deleteCompany(UUID companyid) {
		 stockService.deleteStock(companyid);
			companyRepository.deleteById(companyid);
	}

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

}
