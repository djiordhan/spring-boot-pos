package com.djiordhan.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.djiordhan.pos.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.math.BigDecimal;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByTransactionDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Custom query
    @Query("SELECT t FROM Transaction t WHERE t.total > :total")
    List<Transaction> findByTotalGreaterThan(@Param("total") BigDecimal total);
}