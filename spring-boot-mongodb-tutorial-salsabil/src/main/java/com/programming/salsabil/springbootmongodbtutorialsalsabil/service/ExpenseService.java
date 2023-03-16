package com.programming.salsabil.springbootmongodbtutorialsalsabil.service;

/**
 * Program  : ExpenseService.java  
 * NIM      : 221524058
 * Nama     : Salsabil Khoirunisa
 * Tanggal  : 13 Maret 2023
 */

import com.programming.salsabil.springbootmongodbtutorialsalsabil.model.Expense;
import com.programming.salsabil.springbootmongodbtutorialsalsabil.repository.ExpenseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    
    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    
    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
            .orElseThrow(()->new RuntimeException(
          String.format("Cannot Find Expense by ID %s", expense.getId())));
        
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        
        expenseRepository.save(expense);
    }
    
    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }
    
    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(()->new RuntimeException(
         String.format("Cannot Find Expense by Name %s", name)));
    }
    
    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
