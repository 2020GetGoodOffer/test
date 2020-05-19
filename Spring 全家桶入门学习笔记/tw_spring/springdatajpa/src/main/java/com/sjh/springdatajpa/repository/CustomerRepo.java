package com.sjh.springdatajpa.repository;

import com.sjh.springdatajpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {



    //根据客户id更新名称
    @Query(value = "update Customer set name = ?2 where id = ?1 ")
    @Modifying
    void updateNameById(Long id, String name);


    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> findAllBySQL();


    //根据id查询
    Optional<Customer> findById(Long id);

    //根据名称查询
    Customer findByName(String name);

    //根据 id 和名称查询
    Customer findByIdAndName(Long id, String name);

    //模糊匹配
    Customer findByNameLike(String name);

    Customer findByNameLikeAndIndustry(String name, String industry);
}
