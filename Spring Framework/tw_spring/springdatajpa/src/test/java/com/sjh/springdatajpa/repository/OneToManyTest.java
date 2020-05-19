package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Customer;
import com.sjh.springdatajpa.entity.Linkman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private LinkmanRepo linkmanRepo;

    @Test
    @Transactional
    @Rollback(false)
    public void save(){
        //创建客户和联系人
        Customer customer = new Customer();
        customer.setName("customer");
        Linkman linkman = new Linkman();
        linkman.setName("linkman");
        //保存外键关系
        linkman.setCustomer(customer);
        customer.getLinkmen().add(linkman);
        //保存客户和联系人
        customerRepo.save(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void delete(){
        Customer customer = customerRepo.getOne(13L);
        customerRepo.delete(customer);
    }

}
