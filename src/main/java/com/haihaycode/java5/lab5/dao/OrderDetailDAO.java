package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {}