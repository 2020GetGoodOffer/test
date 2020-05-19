package com.sjh.springdatajpa;

import com.sjh.springdatajpa.entity.Customer;
import com.sjh.springdatajpa.repository.CustomerRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdatajpaApplicationTests {

	@Test
	public void contextLoads() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql:///test?characterEncoding=UTF-8&serverTimezone=UTC",
				"root", "sjh2019");
		System.out.println(connection);
	}


}
