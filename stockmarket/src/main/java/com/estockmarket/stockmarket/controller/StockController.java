package com.estockmarket.stockmarket.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Stock Registration
    @PostMapping("/add/{companyId}")
    public Stock register(@RequestBody Stock stock, @PathVariable(value = "companyId") UUID companyId) throws ParseException {
        return stockService.saveStock(stock,companyId);
    }

    @GetMapping("/getStock/{companyId}")
    public Stock getStockDetails(@PathVariable(value = "companyId") UUID companyId) throws ParseException {
        return stockService.getStockByCompanyId(companyId);
    }

    @GetMapping("/findallstock")
    public List<Stock>  findStock(){
        return stockService.getAllStock();
    }

    @PutMapping("/updateStockPrice/{stockID}")
    public List<Stock>  updateStockPrice( @PathVariable(value = "stockID") UUID stockId, @RequestBody Stock stockPrice) throws ParseException{
        return stockService.updateStockPrice(stockId , stockPrice);
    }
}
