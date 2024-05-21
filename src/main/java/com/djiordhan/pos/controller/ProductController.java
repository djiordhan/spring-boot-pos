package com.djiordhan.pos.controller;

import com.djiordhan.pos.model.Product;
import com.djiordhan.pos.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/find/name/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/find/price-greater-than/{price}")
    public List<Product> findByPriceGreaterThan(@PathVariable BigDecimal price) {
        return productService.findByPriceGreaterThan(price);
    }
}
