package com.sjh.controller;

import com.sjh.entity.Student;
import com.sjh.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepo.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return studentRepo.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepo.update(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepo.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        studentRepo.deleteById(id);
    }

    @GetMapping
    public String index(){
        return "当前端口："+this.port;
    }
}
