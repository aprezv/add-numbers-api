package com.armando.addnumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AddNumbersApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddNumbersApplication.class, args);
    }

}
