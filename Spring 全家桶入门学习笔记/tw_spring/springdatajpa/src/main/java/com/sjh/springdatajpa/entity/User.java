package com.sjh.springdatajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",//中间表名称
            joinColumns = {@JoinColumn(name = "uid",referencedColumnName = "id")},//当前对象在中间表的外键
            inverseJoinColumns = {@JoinColumn(name ="rid" ,referencedColumnName ="id" )})//对方对象在中间表的外键
    private Set<Role> roles=new HashSet<>();

}

