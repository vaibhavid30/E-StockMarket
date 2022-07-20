package com.estockmarket.stockmarket.service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.estockmarket.stockmarket.exception.DataNotAvailable;
import com.estockmarket.stockmarket.model.Stock;
import com.estockmarket.stockmarket.repositories.StockRepository;

@Service
public class StockService {
    
    @Autowired(required = true)
    StockRepository stockRepository;

	@Autowired(required = true)
	MultipleStockService multipleStockService;
	
    public Stock saveStock(@RequestBody Stock stock,UUID companyID) throws ParseException {
		Stock stockSet = new Stock();
		stockSet.setCompanyId(companyID);
		stockSet.setStockId(stock.getStockId());
		stockSet.setStockName(stock.getStockName());
		stockSet.setStockPrice(stock.getStockPrice());
		stockSet.setDate();
		multipleStockService.saveStockData(stockSet);
		return stockRepository.save(stockSet);
	}

	public Stock  getStockByCompanyId(UUID companyId){
		return stockRepository.findStockBycompanyId(companyId);
	}

	public void deleteAllStock(UUID companyid){
		Stock stockDetails = stockRepository.findStockBycompanyId(companyid);
		multipleStockService.deleteAllStock(stockDetails.getStockId());
		stockRepository.deleteById(stockDetails.getStockId());
	}

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

	public List<Stock> updateStockPrice(UUID stockId, Stock stockPrice) throws ParseException {

		List<Stock> stockdetails = stockRepository.findStockByStockId(stockId);
		if (stockdetails != null){

			System.out.println("Stock Price" + stockPrice.getStockPrice());
			stockdetails.get(0).setStockPrice(stockPrice.getStockPrice());
			stockdetails.get(0).setDate();
			multipleStockService.saveStockData(stockdetails.get(0));
			stockRepository.saveAll(stockdetails);
		}else{
			throw new DataNotAvailable("Stocks not available in Database");
		}
		System.out.println("Stock details" + stockdetails);
		return stockdetails;
	}
    
}
