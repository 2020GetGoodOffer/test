package com.sjh.test;

import com.sjh.entity.Car;
import com.sjh.entity.Person;
import com.sjh.entity.Student;
import com.sjh.entity.User;
import com.sjh.factory.StaticFactory;
import com.sjh.ioc.MyApplicationContext;
import com.sjh.ioc.MyClassPathXmlApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCTest {

    @Test
    public void testIoC(){
        Student student = new Student();
        student.setId(1);
        student.setName("sjh");
        student.setAge(24);
        System.out.println(student);
    }

    @Test
    public void testIoC2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

    @Test
    public void testIoC3() throws Exception {
        MyApplicationContext ac=new MyClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

    @Test
    public void testIoC4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student = ac.getBean(Student.class);
        System.out.println(student);
    }

    @Test
    public void testIoC5(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) ac.getBean("student2");
        System.out.println(student);
    }

    @Test
    public void testScope1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student1 = (Student) ac.getBean("student");
        Student student2 = (Student) ac.getBean("student");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1==student2);
    }

    @Test
    public void testExtends(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student1 = (Student) ac.getBean("student");
        Student student2 = (Student) ac.getBean("student2");
        System.out.println(student1);
        System.out.println(student2);
    }

    @Test
    public void testExtends2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) ac.getBean("student");
        User user = (User) ac.getBean("user");
        System.out.println(student);
        System.out.println(user);
    }

    @Test
    public void testDep1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        ac.getBean("student2");
        ac.getBean("user");
    }

    @Test
    public void testFactory1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("factory.xml");
        Car car = (Car) ac.getBean("car");
        System.out.println(car);
    }

    @Test
    public void testFactory2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("factory.xml");
        Car car = (Car) ac.getBean("car2");
        System.out.println(car);
    }

    @Test
    public void testAutowired1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("autowire.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }
}
