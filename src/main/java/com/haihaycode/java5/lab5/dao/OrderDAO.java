package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {}