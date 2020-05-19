package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Customer;
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

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepoSpecTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void findOne(){
        //构建自定义查询条件
        Specification<Customer> spec = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> name = root.get("name");//获取比较的属性
            return criteriaBuilder.equal(name, "sjh");
        };
        Optional<Customer> customer = customerRepo.findOne(spec);
        System.out.println(customer);
    }

    @Test
    public void findOne2(){
        Specification<Customer> spec = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> name = root.get("name");
            Path<Object> industry = root.get("industry");
            Predicate p1 = criteriaBuilder.equal(name, "sjh");
            Predicate p2 = criteriaBuilder.equal(industry, "it");
            return criteriaBuilder.and(p1,p2);
        };
        Optional<Customer> customer = customerRepo.findOne(spec);
        System.out.println(customer);
    }

    @Test
    public void findAll(){
        Specification<Customer> spec = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> name = root.get("name");
            return criteriaBuilder.like(name.as(String.class),"s%");
        };
        List<Customer> customers = customerRepo.findAll(spec);
        System.out.println(customers);
    }

    @Test
    public void findSort(){
        Specification<Customer> spec = (Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> name = root.get("name");
            return criteriaBuilder.like(name.as(String.class),"s%");
        };
        //创建排序对象
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Customer> customers = customerRepo.findAll(spec, sort);
        System.out.println(customers);
    }

    @Test
    public void findPage(){
        Specification<Customer> spec = null;
        Pageable pageable = PageRequest.of(0,2);
        //创建分页对象
        Page<Customer> customers = customerRepo.findAll(spec, pageable);
        System.out.println("总条数：" + customers.getTotalElements());
        System.out.println("页数"+ customers.getTotalPages());
        System.out.println("数据"+ customers.getContent());
    }

}
