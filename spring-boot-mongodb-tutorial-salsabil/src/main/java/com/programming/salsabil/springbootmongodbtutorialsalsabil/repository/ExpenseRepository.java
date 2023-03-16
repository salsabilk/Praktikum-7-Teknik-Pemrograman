package com.programming.salsabil.springbootmongodbtutorialsalsabil.repository;

/**
 * Program  : ExpenseRepository.java  
 * NIM      : 221524058
 * Nama     : Salsabil Khoirunisa
 * Tanggal  : 13 Maret 2023
 */

import com.programming.salsabil.springbootmongodbtutorialsalsabil.model.Expense;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExpenseRepository extends MongoRepository<Expense, String>{
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
