package com.sjh.springdatajpa.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="linkman")
public class Linkman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long id;

    @Column(name ="lkm_name" )
    private String name;

    @Column(name = "lkm_gender")
    private String gender;

    @Column(name = "lkm_phone")
    private String phone;

    @Column(name = "lkm_mobile")
    private String mobile;

    @Column(name = "lkm_email")
    private String email;

    @Column(name = "lkm_position")
    private String position;

    @Column(name = "lkm_memo")
    private String memo;

    //配置表关系
    @ManyToOne(targetEntity = Customer.class)
    //配置外键
    @JoinColumn(name ="lkm_cust_id" ,referencedColumnName = "cust_id")
    private Customer customer;


}
