package com.sjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    public Student(){
        System.out.println("创建了Student对象");
    }

    private Integer id;

    private String name;

    private Integer age;

    private List<Address> addresses;


}
