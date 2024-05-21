package com.djiordhan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.djiordhan.pos.model.Product;

import java.math.BigDecimal;
import java.util.List;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    // Custom query
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceGreaterThan(@Param("price") BigDecimal price);

}
