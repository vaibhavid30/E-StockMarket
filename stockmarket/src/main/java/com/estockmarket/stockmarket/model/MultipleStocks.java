package com.estockmarket.stockmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("multipleStock")
public class MultipleStocks implements Serializable {

    @PrimaryKey
    private UUID id;
    private UUID stockId;
    private String stockName;
    private BigDecimal stockPrice;
    private LocalDate date; 

    public MultipleStocks() {
        
    }

    public MultipleStocks(UUID id, UUID stockId, String stockName, BigDecimal stockPrice, LocalDate date) {
        this.stockId = stockId;
        this.id= id;
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        this.date = date;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date)  {
        this.date = date;
       
    }

}