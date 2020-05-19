package com.sjh.controller;

import com.sjh.entity.Student;
import com.sjh.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RESTController {

    @Autowired
    private StudentRepo sr;

    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");//防止中文乱码
        return sr.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return sr.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        sr.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        sr.deleteById(id);
    }
}
