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
    CommandLineRunner initDatabase(ProductRepository repository, OrderRepository orderRepository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Laptop", 1299.99, true, Product.Category.ELECTRONICS, "TechCo", "good")));
            log.info("Preloading " + repository.save(new Product("Introduction to Spring", 29.99, false, Product.Category.BOOKS, "TechBooks", "no description needed")));



            orderRepository.save(new Order("MacBook", Status.COMPLETED));
            orderRepository.save(new Order("Phone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });





        };
    }
}