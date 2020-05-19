package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepoJPQLTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void findByName(){
        Customer sjh = customerRepo.findByName("sjh");
        System.out.println(sjh);
    }

    @Test
    public void findByIdAndName(){
        Customer sjh = customerRepo.findByIdAndName(4L,"sjh2");
        System.out.println(sjh);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void updateNameById(){
        customerRepo.updateNameById(1L,"sjh1");
    }

    @Test
    public void findAllBySQL(){
        List<Customer> customers = customerRepo.findAllBySQL();
        System.out.println(customers);
    }

    @Test
    public void findByNameLike(){
        Customer customers = customerRepo.findByNameLike("sjh%");
        System.out.println(customers);
    }

}
