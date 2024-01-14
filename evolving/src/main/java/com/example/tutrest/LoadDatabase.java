package com.example.tutrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Laptop"," Lenevo", 1299.99, true, Product.Category.ELECTRONICS, "TechCo", "good")));
            log.info("Preloading " + repository.save(new Product("Introduction to Spring", "2nd edition",29.99, false, Product.Category.BOOKS, "TechBooks", "no description needed")));
        };
    }
}