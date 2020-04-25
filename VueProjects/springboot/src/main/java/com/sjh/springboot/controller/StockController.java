package com.sjh.springboot.controller;

import com.sjh.springboot.entity.Stock;
import com.sjh.springboot.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//声明基于rest的控制器
@RequestMapping("/stock")//根url配置
public class StockController {

    @Autowired//自动注入
    private StockRepository stockRepository;

    @GetMapping("/findAll/{page}/{size}")//get请求所有数据
    public Page<Stock> findAll(@PathVariable("page")Integer page, @PathVariable("size")Integer size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return stockRepository.findAll(pageRequest);
    }

    @GetMapping("/findById/{id}")//get请求单个数据
    public Stock findById(@PathVariable("id")Integer id){
        return stockRepository.findById(id).get();
    }

    @PostMapping("/save")//post请求提交数据
    public void save(@RequestBody Stock stock){
        stockRepository.save(stock);
    }

    @PutMapping("/update")//put请求修改数据
    public void update(@RequestBody Stock stock){
        stockRepository.save(stock);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id")Integer id){
        stockRepository.deleteById(id);
    }
}
