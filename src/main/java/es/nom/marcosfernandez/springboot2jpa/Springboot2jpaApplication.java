package es.nom.marcosfernandez.springboot2jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "es.nom.marcosfernandez.*")
@EntityScan(basePackages = "es.nom.marcosfernandez.springboot2jpa")
@EnableJpaRepositories(basePackages = "es.nom.marcosfernandez.springboot2jpa.repositories")
public class Springboot2jpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2jpaApplication.class, args);
    }

}
