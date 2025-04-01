package com.examly.springapp.services;
import com.examly.springapp.entities.Budget;
import com.examly.springapp.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BudgetService
{
    @Autowired
    private BudgetRepository budgetRepository;
    public List<Budget> getAllBudgets()
    {
        return budgetRepository.findAll();
    }
    public Optional<Budget> getBudgetById(Long id)
    {
        return budgetRepository.findById(id);
    }
    public List<Budget> findByCategory(String category)
    {
        return budgetRepository.findByCategory(category);
    }
    public Budget saveBudget(Budget budget)
    {
        return budgetRepository.save(budget);
    }
    public Budget updateBudget(Long id, Budget updatedBudget)
    {
        return budgetRepository.findById(id).map(budget -> 
        {
            budget.setCategory(updatedBudget.getCategory());
            budget.setAllocatedAmount(updatedBudget.getAllocatedAmount());
            return budgetRepository.save(budget);
        }).orElseThrow(() -> new RuntimeException("Budget not found with ID: " + id));
    }
    public void deleteBudget(Long id)
    {
        budgetRepository.deleteById(id);
    }
    public Page<Budget> getAllPage(Pageable pg) 
    {
        return budgetRepository.findAll(pg);
    }
}