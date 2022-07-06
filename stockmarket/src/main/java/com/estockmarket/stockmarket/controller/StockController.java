package com.estockmarket.stockmarket.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.stockmarket.model.Stock;
import com.estockmarket.stockmarket.service.StockService;

@RestController
@CrossOrigin
@RequestMapping("market/stock")
public class StockController {
    
    @Autowired
    StockService stockService;

    // Company Reggistration
    @PostMapping("/register")
    public Stock register(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @GetMapping("/findstock/{companyID}")
    public Optional<Stock>  findStock(@PathVariable (value = "companyID") UUID companyID){
        return stockService.getStockByCompanyId(companyID);
    }
}
