package com.haihaycode.java5.lab5.dao;

import com.haihaycode.java5.lab5.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account, String> {
  Account findByUsername(String UserName);
  List<Account> findAll();

}
