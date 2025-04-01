package com.examly.springapp.repositories;
import com.examly.springapp.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExpenseRepository extends JpaRepository<Expense, Long> 
{
    
}