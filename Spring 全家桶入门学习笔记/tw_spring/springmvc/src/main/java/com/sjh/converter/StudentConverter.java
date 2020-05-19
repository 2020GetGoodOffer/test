package com.sjh.converter;

import com.sjh.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class StudentConverter implements Converter<String, Student> {

    @Override
    public Student convert(String source) {
        System.out.println("转换");
        String[] info = source.split("-");
        Student student = new Student();
        student.setId(Integer.parseInt(info[0]));
        student.setName(info[1]);
        student.setAge(Integer.parseInt(info[2]));
        return student;
    }

}
