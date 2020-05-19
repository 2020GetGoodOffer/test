package com.sjh.repository;


import com.sjh.entity.Student;

import java.util.Collection;

public interface StudentRepo{

    Collection<Student> findAll();

    Student findById(Integer id);

    void update(Student student);

    void deleteById(Integer id);
}
