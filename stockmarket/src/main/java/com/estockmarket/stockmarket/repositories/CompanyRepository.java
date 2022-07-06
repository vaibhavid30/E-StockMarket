package com.estockmarket.stockmarket.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.estockmarket.stockmarket.model.Company;

@Repository
public interface CompanyRepository extends CassandraRepository<Company, UUID>{
    
    @AllowFiltering
    public List<Company> findAllCompanyByuserID(UUID userId);

    @AllowFiltering
    public Company findByCompanyID(UUID companyID);

}
