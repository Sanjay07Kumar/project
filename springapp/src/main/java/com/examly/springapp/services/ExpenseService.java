package com.examly.springapp.services;
import com.examly.springapp.entities.Expense;
import com.examly.springapp.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ExpenseService
{
    @Autowired
    private ExpenseRepository expenseRepository;
    public List<Expense> getAllExpenses()
    {
        return expenseRepository.findAll();
    }
    public Optional<Expense> getExpenseById(Long id)
    {
        return expenseRepository.findById(id);
    }
    public Expense addExpense(Expense expense)
    {
        return expenseRepository.save(expense);
    }
    public Expense updateExpense(Long id, Expense expenseDetails) 
    {
        return expenseRepository.findById(id).map(expense -> 
        {
            expense.setName(expenseDetails.getName());
            expense.setAmount(expenseDetails.getAmount());
            return expenseRepository.save(expense);
        }).orElseThrow(() -> new RuntimeException("Expense not found"));
    }
    public void deleteExpense(Long id)
    {
        expenseRepository.deleteById(id);
    }
     public Page<Expense> getAllPage(Pageable pg) 
    {
        return expenseRepository.findAll(pg);
    }
}