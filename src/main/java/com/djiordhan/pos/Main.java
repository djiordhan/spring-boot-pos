package com.djiordhan.pos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djiordhan.pos.model.Book;
import com.djiordhan.pos.repository.BookRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
      SpringApplication.run(Main.class, args);
    }

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

    @GetMapping("/insert")
    public String insert() {

      System.out.println("Running.....");

            Book b1 = new Book("Book A",
                    BigDecimal.valueOf(9.99),
                    LocalDate.of(2023, 8, 31));
            Book b2 = new Book("Book B",
                    BigDecimal.valueOf(19.99),
                    LocalDate.of(2023, 7, 31));
            Book b3 = new Book("Book C",
                    BigDecimal.valueOf(29.99),
                    LocalDate.of(2023, 6, 10));
            Book b4 = new Book("Book D",
                    BigDecimal.valueOf(39.99),
                    LocalDate.of(2023, 5, 5));

            bookRepository.saveAll(List.of(b1, b2, b3, b4));

            
      return "inserted";
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}