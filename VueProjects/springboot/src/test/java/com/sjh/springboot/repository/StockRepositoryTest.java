package com.sjh.springboot.repository;

import com.sjh.springboot.entity.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockRepositoryTest {

    @Autowired
    private StockRepository stockRepository;

    @Test
    void findAll(){
        System.out.println(stockRepository.findAll());
    }

    @Test
    public void save(){
        Stock stock = new Stock();
        stock.setName("asda");
        stock.setPrice(13.1);
        stock.setRate(1.3);
        stockRepository.save(stock);
    }
}