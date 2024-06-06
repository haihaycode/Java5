package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.Product;
import com.haihaycode.java5.lab6.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

        List<Product> findByPriceBetween(Double min, Double max);
        @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
        Page<Product> findByKeywords(String keywords, Pageable pageable);

        @Query(value = "SELECT new com.haihaycode.java5.lab6.model.Report(o.category, sum(o.price), count(o)) " +
                "FROM Product o " +
                "GROUP BY o.category " +
                "ORDER BY sum(o.price) DESC")
        List<Report> getInventoryByCategory();

        Page<Product> findByCreateDateBetween(Date before, Date after, Pageable pageable);



}
