package com.sjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class User {

    public User(){
        System.out.println("创建了User对象");
    }

    private Integer id;

    private String name;

    private Integer age;

    private List<Address> addresses;

    private Double salary;
}
