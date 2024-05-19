package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {}
