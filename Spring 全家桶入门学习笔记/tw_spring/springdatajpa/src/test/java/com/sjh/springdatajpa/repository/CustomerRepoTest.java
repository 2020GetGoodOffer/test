package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepoTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void findById(){
        Optional<Customer> customer = customerRepo.findById(1L);
        System.out.println(customer);
    }

    @Test
    public void findAll(){
        List<Customer> customers = customerRepo.findAll();
        System.out.println(customers);
    }

    @Test
    public void save(){
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setName("kobe");
        customerRepo.save(customer);
    }

    @Test
    public void update(){
        Customer customer = new Customer();
        customer.setName("sjh");
        customerRepo.save(customer);
    }

    @Test
    public void delete(){
        customerRepo.deleteById(3L);
    }

    @Test
    public void count(){
        long count = customerRepo.count();
        System.out.println("记录数："+count);
    }

    @Test
    public void exists(){
        boolean exists = customerRepo.existsById(2L);
        System.out.println("该客户记录："+ (exists?"存在":"不存在"));
    }

    @Test
    @Transactional
    public void getOne(){
        Customer one = customerRepo.getOne(1L);
        System.out.println(one);
    }

}
