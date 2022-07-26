package com.estockmarket.stockmarket.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.estockmarket.stockmarket.model.MultipleStocks;


@Repository
public interface MultipleStockRepository extends CassandraRepository<MultipleStocks, UUID> {

    @AllowFiltering
    public List<MultipleStocks> findMultipleStocksByStockId(UUID stockId);
    
    @AllowFiltering
    @Query("delete from multipleStock  where stockid = ?0")
    public void deleteByStockId(UUID stockID);

    @AllowFiltering
    @Query("select * from multipleStock  where stockid = ?2 AND date >= ?0 AND date < ?1 ALLOW FILTERING")
public List<MultipleStocks> getMultipleStocksByDate(LocalDate dateBefore, LocalDate dateAfter, UUID stockId);
}
