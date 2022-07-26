package com.estockmarket.stockmarket.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockmarket.stockmarket.model.Details;
import com.estockmarket.stockmarket.model.MultipleStocks;
import com.estockmarket.stockmarket.model.Stock;
import com.estockmarket.stockmarket.repositories.MultipleStockRepository;

@Service
public class MultipleStockService {
    
    @Autowired(required = true)
    MultipleStockRepository multipleStockRepository;
	
    public void saveStockData(Stock stock) throws ParseException {
        MultipleStocks stockData = new MultipleStocks();
        stockData.setId(UUID.randomUUID());
        stockData.setStockId(stock.getStockId());
        stockData.setStockName(stock.getStockName());
        stockData.setStockPrice(stock.getStockPrice()); 
      //  Calendar cal = Calendar.getInstance();

      // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     //   String dateInString = stock.getDate();
     //   Date date = formatter.parse(dateInString);
     //   System.out.println(formatter.format(cal.getTime()));

     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate date = LocalDate.parse(stock.getDate(), formatter);
System.out.println(date);
        stockData.setDate(date);
        System.out.println("Date: "+date);
        multipleStockRepository.save(stockData);
    }
    
    public void deleteAllStock(UUID stockID){
       List<MultipleStocks> stockHistory= multipleStockRepository.findMultipleStocksByStockId(stockID);
       for(MultipleStocks ms : stockHistory){
        System.out.println("Inside delete multiple stocks");
        multipleStockRepository.deleteById(ms.getId());
       }
		
	}

    public List<MultipleStocks> getStockHistory(Details details){
        List<MultipleStocks> multipleStocksBtwDates = new ArrayList<>();
        List<MultipleStocks> data = new ArrayList<>();
        LocalDate dateBefore = details.getDate();
        LocalDate dateAfter = details.getEndDate();
        UUID stockId = details.getStockId();
        System.out.println("Date after parsing: "+dateBefore + dateAfter);
        multipleStocksBtwDates = multipleStockRepository.getMultipleStocksByDate(dateBefore, dateAfter, stockId);
        for(MultipleStocks stk:multipleStocksBtwDates){
            
           System.out.println(stk.getStockId());
           
        }
        for(MultipleStocks stk:multipleStocksBtwDates){
            
            if(stockId == stk.getStockId()){
                data.add(stk);
                System.out.println(stk);
            }
           
        }
        System.out.print(" Data - " +data);

        return multipleStocksBtwDates;

    }
}
