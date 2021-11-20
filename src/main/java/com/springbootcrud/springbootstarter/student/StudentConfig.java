package com.springbootcrud.springbootstarter.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@test.com",
                    LocalDate.of(1999,2,2)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@test.com",
                    LocalDate.of(1997,2,8)
            );
            Student stan = new Student(
                    "Stan",
                    "stan@test.com",
                    LocalDate.of(2000,1,18)
            );

            repository.saveAll(List.of(mariam,alex,stan));
        };
    }
}
