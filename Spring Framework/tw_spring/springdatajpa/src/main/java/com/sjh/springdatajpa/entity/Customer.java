package com.sjh.springdatajpa.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id//声明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键生产策略
    @Column(name = "cust_id")//配置属性和字段的映射关系 name配置数据库字段名
    private Long id;//主键

    @Column(name = "cust_name")
    private String name;//名称

    @Column(name = "cust_source")
    private String source;//来源

    @Column(name = "cust_industry")
    private String industry;//行业

    @Column(name = "cust_level")
    private String level;//级别

    @Column(name = "cust_address")
    private String address;//地址

    @Column(name = "cust_phone")
    private String phone;//联系方式

    //配置一对多关系
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Linkman> linkmen = new HashSet<>();

}
