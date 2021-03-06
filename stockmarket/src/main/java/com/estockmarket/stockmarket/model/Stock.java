package com.estockmarket.stockmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("stock")
public class Stock implements Serializable {

    @PrimaryKey
    private UUID stockId;
    private UUID companyId;
    private String stockName;
    private BigDecimal stockPrice;
    private String date; 

    public Stock() {
        stockId = UUID.randomUUID();
    }

    public Stock(UUID stockId, String stockName, BigDecimal stockPrice, UUID companyId, String date) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.companyId = companyId;
        this.date = date;
    }

    public UUID getStockId() {
        return this.stockId;
    }

    public void setStockId(UUID stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return this.stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getStockPrice() {
        return this.stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public UUID getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate() throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.date = simpleDateFormat.format(new Date());
    }

}