package com.sjh.controller;

import com.sjh.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/converter")
public class converterController {

    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }

    @RequestMapping("/stu")
    public String stu(Student student){
        return student.toString();
    }
}
