package com.lakshayjain;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.lakshayjain.Customers.Customer;
import com.lakshayjain.Customers.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //   NEVER DO THIS
//        CustomerService customerService = new CustomerService(new CustomerDataAccessService());
//        CustomerController customerController = new CustomerController(customerService);

//        ConfigurableApplicationContext context =
                SpringApplication.run(Main.class, args);

//        printAllBeans(context);

    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {

        return args -> {
            Faker faker = new Faker();
            Random random = new Random();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Customer customer = new Customer(
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com",
                    random.nextInt(16,99)
            );
            customerRepository.save(customer);
        };
    }

    private static void printAllBeans(ConfigurableApplicationContext cac) {
        String[] beanDefinitionNames = cac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
