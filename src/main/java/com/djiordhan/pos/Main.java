package com.djiordhan.pos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.djiordhan.pos.model.Product;
import com.djiordhan.pos.model.Transaction;
import com.djiordhan.pos.model.Cart;
import com.djiordhan.pos.repository.ProductRepository;
import com.djiordhan.pos.repository.TransactionRepository;

@SpringBootApplication
@RestController
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner seedDatabase(ProductRepository productRepository, TransactionRepository transactionRepository) {
        return args -> {
            long productCount = productRepository.count();
            if (productCount == 0) {
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
                logger.info("Product seeding completed.");
            } else {
                logger.info("Products found, no product seeding necessary.");
            }

            long transactionCount = transactionRepository.count();
            if (transactionCount == 0) {
                logger.info("No transactions found, seeding database with 5 transactions.");
                for (int i = 1; i <= 5; i++) {
                    List<Cart> carts = new ArrayList<>();
                    for (int j = 1; j <= 3; j++) {
                        Cart cart = new Cart("Product " + j, 1, BigDecimal.valueOf(10.0 + j));
                        carts.add(cart);
                    }
                    Transaction transaction = new Transaction(
                            BigDecimal.valueOf(100.0 + i),
                            BigDecimal.valueOf(120.0 + i),
                            BigDecimal.valueOf(20.0),
                            LocalDateTime.now().minusDays(i)
                    );
                    transaction.setCarts(carts); // This sets the transaction reference in each cart
                    transactionRepository.save(transaction);
                }
                logger.info("Transaction seeding completed.");
            } else {
                logger.info("Transactions found, no transaction seeding necessary.");
            }
        };
    }
}
