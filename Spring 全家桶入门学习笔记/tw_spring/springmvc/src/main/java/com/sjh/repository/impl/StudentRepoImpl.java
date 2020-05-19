package com.sjh.repository.impl;

import com.sjh.entity.Student;
import com.sjh.repository.StudentRepo;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepoImpl implements StudentRepo {

    //模拟数据库信息
    private static Map<Integer,Student> map;

    static {
        map = new HashMap<>();
        //map.put(1,new Student(1,"sjh",24));
        //map.put(2,new Student(2,"sjh",23));
        //map.put(3,new Student(3,"sjh",22));
    }

    @Override
    public Collection<Student> findAll() {
        return map.values();
    }

    @Override
    public Student findById(Integer id) {
        return map.get(id);
    }

    @Override
    public void update(Student student) {
        map.put(student.getId(),student);
    }

    @Override
    public void deleteById(Integer id) {
        map.remove(id);
    }
}
