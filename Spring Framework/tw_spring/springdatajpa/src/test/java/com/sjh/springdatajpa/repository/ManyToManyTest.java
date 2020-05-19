package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Customer;
import com.sjh.springdatajpa.entity.Linkman;
import com.sjh.springdatajpa.entity.Role;
import com.sjh.springdatajpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Test
    @Transactional
    @Rollback(false)
    public void delete(){
        userRepo.deleteById(5L);
    }


}
