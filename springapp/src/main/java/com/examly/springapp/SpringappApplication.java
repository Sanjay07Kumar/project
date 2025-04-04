package com.examly.springapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EntityScan("com.examly.springapp.entities")
@EnableJpaRepositories("com.examly.springapp.repositories")
public class SpringappApplication 
{
        public static void main(String[] args) 
    {
        SpringApplication.run(SpringappApplication.class, args);
    }
}
