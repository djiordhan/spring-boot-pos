package com.djiordhan.pos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.djiordhan.pos.model.Product;
import com.djiordhan.pos.repository.ProductRepository;

@SpringBootApplication
@RestController
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner seedDatabase(ProductRepository productRepository) {
        return args -> {
            long count = productRepository.count();
            if (count == 0) {
                logger.info("No products found, seeding database with 10 products.");
                for (int i = 1; i <= 10; i++) {
                    Product product = new Product(
                            "Product " + i,
                            "Description for product " + i,
                            BigDecimal.valueOf(10.0 + i),
                            "imagePath" + i + ".jpg"
                    );
                    productRepository.save(product);
                }
                logger.info("Seeding completed.");
            } else {
                logger.info("Products found, no seeding necessary.");
            }
        };
    }
}
