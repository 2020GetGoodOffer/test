package com.sjh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String  name;

    private int age;

    private List<String> hobby;
    private List<String> selectHobby;
}
