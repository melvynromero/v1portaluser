package com.javasampleapproach.jdbcpostgresql;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.javasampleapproach.jdbcpostgresql.model.Customer;
import com.javasampleapproach.jdbcpostgresql.service.CustomerService;

@SpringBootApplication
@ComponentScan("com.javasampleapproach.jdbcpostgresql.service.impl, com.javasampleapproach.jdbcpostgresql.dao.impl")
public class SpringJdbcTemplatePostgreSqlApplication implements CommandLineRunner {

	@Autowired
	CustomerService cusService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplatePostgreSqlApplication.class, args);
		// CustomerService cusService = context.getBean(CustomerService.class);
	}

	@Override
	public void run(String... args) throws Exception {
		 Random r = new Random();
		 
		 // Customer 1
		 Customer cus_1 = new Customer();
		 Long cus_1_id = r.nextLong();
		 cus_1.setCustId(cus_1_id);
		 cus_1.setName("demoCustomer_1");
		 cus_1.setAge(30);
		 System.out.println("Cus 1 created");
		 
		 // Customer 2
		 Customer cus_2 = new Customer();
		 Long cus_2_id = r.nextLong();
		 cus_2.setCustId(cus_2_id);
		 cus_2.setName("demoCustomer_2");
		 cus_2.setAge(30);
		 System.out.println("Cus 2 created");
		 
		 // Customer 3
		 Customer cus_3 = new Customer();
		 Long cus_3_id = r.nextLong();
		 cus_3.setCustId(cus_3_id);
		 cus_3.setName("demoCustomer_3");
		 cus_3.setAge(30);
		 System.out.println("Cus 3 created");

		 // Insert a customer to DB
		 cusService.insert(cus_1);
		 System.out.println("Cus 1 inserted");
		 
		 // Insert a List of Customer to DB
		 List<Customer> customers = new ArrayList<Customer>();
		 customers.add(cus_2);
		 customers.add(cus_3);
		 cusService.insertBatch(customers);
		 System.out.println("Cus list inserted");
		 
		 // Load All Customer and display
		 cusService.loadAllCustomer();
		 System.out.println("Cus listed");
		 
		 // Get Customer’s name by Id
		 cusService.getCustomerNameById(cus_2_id);
		 System.out.println("Cus by name");
		 
		 // Get Total Customers in DB
		 cusService.getTotalNumberCustomer();
		 System.out.println("Cus tot number");
		 
	}
}






