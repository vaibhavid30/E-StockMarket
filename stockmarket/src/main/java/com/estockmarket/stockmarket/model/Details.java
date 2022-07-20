package com.estockmarket.stockmarket.model;

import java.time.LocalDate;


public class Details extends MultipleStocks {
    private LocalDate endDate; 

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate)  {
        this.endDate = endDate;
       
    }
}
