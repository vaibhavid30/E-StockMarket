package com.estockmarket.stockmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("company")
public class Company implements Serializable {

    @PrimaryKey
    private UUID companyID;
    private String companyName;
    private String companyCEO;
    private BigDecimal companyTurnOver;
    private String companyWebsite;
    private String companyStockExchange;

    public Company(UUID companyID, String companyName, String companyCEO, BigDecimal companyTurnOver,
            String companyWebsite, String companyStockExchange) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.companyCEO = companyCEO;
        this.companyTurnOver = companyTurnOver;
        this.companyWebsite = companyWebsite;
        this.companyStockExchange = companyStockExchange;
    }

    public UUID getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(UUID companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCEO() {
        return this.companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public BigDecimal getCompanyTurnOver() {
        return this.companyTurnOver;
    }

    public void setCompanyTurnOver(BigDecimal companyTurnOver) {
        this.companyTurnOver = companyTurnOver;
    }

    public String getCompanyWebsite() {
        return this.companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyStockExchange() {
        return this.companyStockExchange;
    }

    public void setCompanyStockExchange(String companyStockExchange) {
        this.companyStockExchange = companyStockExchange;
    }

    public Company() {
        companyID = UUID.randomUUID();
    }

}
