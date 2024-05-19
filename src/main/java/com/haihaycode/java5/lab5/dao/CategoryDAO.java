package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, String> {}
