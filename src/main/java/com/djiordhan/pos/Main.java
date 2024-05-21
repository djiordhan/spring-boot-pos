package com.djiordhan.pos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
                logger.info("No products found, seeding database with specified products.");
                List<Product> products = List.of(
                    new Product("Burger", "Delicious burger", BigDecimal.valueOf(50.00), "/product-images/burger.jpeg"),
                    new Product("Donut", "Tasty donut", BigDecimal.valueOf(20.00), "/product-images/donut.jpeg"),
                    new Product("Sandwich", "Fresh sandwich", BigDecimal.valueOf(40.00), "/product-images/sandwich.jpeg"),
                    new Product("Cinnamon Roll", "Sweet cinnamon roll", BigDecimal.valueOf(50.00), "/product-images/cinnamonroll.jpeg"),
                    new Product("Crosaint", "Flaky crosaint", BigDecimal.valueOf(20.00), "/product-images/crosaint.jpeg"),
                    new Product("Espresso", "Strong espresso", BigDecimal.valueOf(40.00), "/product-images/espresso.jpeg"),
                    new Product("Frappe", "Cold frappe", BigDecimal.valueOf(40.00), "/product-images/frappe.jpeg"),
                    new Product("Milk Tea", "Refreshing milk tea", BigDecimal.valueOf(40.00), "/product-images/milktea.jpeg"),
                    new Product("Black Coffee", "Bold black coffee", BigDecimal.valueOf(40.00), "/product-images/blackcoffee.jpeg")
                );
                productRepository.saveAll(products);
                logger.info("Product seeding completed.");
            } else {
                logger.info("Products found, no product seeding necessary.");
            }

            // long transactionCount = transactionRepository.count();
            // if (transactionCount == 0) {
            //     logger.info("No transactions found, seeding database with sample transactions.");
            //     for (int i = 1; i <= 5; i++) {
            //         List<Cart> carts = List.of(
            //             new Cart("Burger", 1, BigDecimal.valueOf(50.00)),
            //             new Cart("Donut", 1, BigDecimal.valueOf(20.00)),
            //             new Cart("Sandwich", 1, BigDecimal.valueOf(40.00))
            //         );
            //         Transaction transaction = new Transaction(
            //                 BigDecimal.valueOf(110.00),
            //                 BigDecimal.valueOf(130.00),
            //                 BigDecimal.valueOf(20.00),
            //                 LocalDateTime.now().minusDays(i)
            //         );
            //         transaction.setCarts(carts); // This sets the transaction reference in each cart
            //         transactionRepository.save(transaction);
            //     }
            //     logger.info("Transaction seeding completed.");
            // } else {
            //     logger.info("Transactions found, no transaction seeding necessary.");
            // }
        };
    }
}
