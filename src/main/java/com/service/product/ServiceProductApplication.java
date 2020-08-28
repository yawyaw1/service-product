package com.service.product;

import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class ServiceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProductApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository productRepository) {
        return args -> Stream.of(new Product(1L, "P1", LocalDateTime.now()),
                new Product(2L, "P2", LocalDateTime.now()),
                new Product(3L, "P3", LocalDateTime.now()),
                new Product(4L, "P4", LocalDateTime.now()),
                new Product(5L, "P5", LocalDateTime.now()))
				.forEach(productRepository::save);
    }

}
