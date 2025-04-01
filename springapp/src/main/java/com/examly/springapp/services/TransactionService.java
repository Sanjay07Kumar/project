package com.examly.springapp.services;

import com.examly.springapp.entities.Category;
import com.examly.springapp.entities.Transaction;
import com.examly.springapp.repositories.CategoryRepository;
import com.examly.springapp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository; // ✅ Autowire TransactionRepository
    
    @Autowired
    private CategoryRepository categoryRepository; // ✅ Autowire CategoryRepository

    public Transaction saveTransaction(Transaction transaction) {
        // Ensure the category exists before saving the transaction
        Optional<Category> category = categoryRepository.findById(transaction.getCategory().getId());
        
        if (category.isEmpty()) {
            throw new RuntimeException("Category not found!"); // ✅ Handle missing category
        }

        transaction.setCategory(category.get()); // ✅ Set valid category
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        return transactionRepository.findById(id).map(existingTransaction -> {
            existingTransaction.setAmount(transaction.getAmount());
            existingTransaction.setCategory(transaction.getCategory());
            existingTransaction.setDate(transaction.getDate());
            existingTransaction.setType(transaction.getType());
            return transactionRepository.save(existingTransaction);
        }).orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Page<Transaction> getAllPage(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
}
