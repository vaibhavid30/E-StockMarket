package com.estockmarket.stockmarket.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.estockmarket.stockmarket.model.Stock;

@Repository
public interface StockRepository extends CassandraRepository<Stock, UUID> {

    @AllowFiltering
    public Stock findStockBycompanyId(UUID companyId);

    @AllowFiltering
    public List<Stock> findStockByStockId(UUID stockId);

}
