package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, String> {}
