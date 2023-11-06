package com.sparta.springintroductionpersonalassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringIntroductionPersonalAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroductionPersonalAssignmentApplication.class, args);
    }

}
