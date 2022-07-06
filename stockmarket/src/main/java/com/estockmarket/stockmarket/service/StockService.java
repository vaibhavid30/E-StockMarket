package com.estockmarket.stockmarket.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.estockmarket.stockmarket.model.Stock;
import com.estockmarket.stockmarket.repositories.StockRepository;

@Service
public class StockService {
    
    @Autowired(required = true)
    StockRepository stockRepository;
	
    public Stock saveStock(@RequestBody Stock stock) {
		Stock stockSet = new Stock();
		stockSet.setCompanyId(stock.getCompanyId());
		stockSet.setEndDate(stock.getEndDate());
		stockSet.setStartDate(stock.getStartDate());
		stockSet.setStockId(stock.getStockId());
		stockSet.setStockName(stock.getStockName());
		stockSet.setStockPrice(stock.getStockPrice());
		return stockRepository.save(stockSet);
	}

	public Optional<Stock>  getStockByCompanyId(UUID companyId){
		return stockRepository.findStockBycompanyId(companyId);
	}

    public Optional<Stock> getStockByStockId(UUID stockId) {
        return stockRepository.findById(stockId);
    }

	public List<Stock> deleteStock(UUID companyid){
		// stockRepository.deleteByCompanyId(companyid);
		stockRepository.findStockBycompanyId(companyid).ifPresent(stock -> stockRepository.deleteByCompanyId(companyid));
		return null;
	}
    
}
