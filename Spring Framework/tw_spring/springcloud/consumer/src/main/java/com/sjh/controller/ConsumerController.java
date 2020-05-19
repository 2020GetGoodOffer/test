package com.sjh.controller;

import com.sjh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/stu/findAll",Collection.class).getBody();
        //return restTemplate.getForObject("http://localhost:8010/stu/findAll",Collection.class);
    }


    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return restTemplate.getForEntity("http://localhost:8010/stu/findById/{id}",Student.class,id).getBody();
        //return restTemplate.getForObject("http://localhost:8010/stu/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/stu/save",student,null).getBody();
        //restTemplate.postForObject("http://localhost:8010/stu/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/stu/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8010/stu/deleteById/{id}",id);
    }
}
