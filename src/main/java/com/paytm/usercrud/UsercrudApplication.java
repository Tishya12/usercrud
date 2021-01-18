package com.paytm.usercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UsercrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsercrudApplication.class, args);
    }

}
