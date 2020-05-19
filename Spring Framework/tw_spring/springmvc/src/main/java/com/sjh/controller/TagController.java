package com.sjh.controller;


import com.sjh.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/tag")
public class TagController {

    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("show");
        Student student = new Student(1,"sjh",24, Arrays.asList("打球","看电影","游戏"), Arrays.asList("打球", "游戏"));
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
