package com.examly.springapp.controllers;
import com.examly.springapp.entities.Budget;
import com.examly.springapp.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("budgets")
public class BudgetController
{
    @Autowired
    private BudgetService budgetService;
    @GetMapping
    public List<Budget> getAllBudgets()
    {
        return budgetService.getAllBudgets();
    }
    @GetMapping("/{id}")
    public Optional<Budget> getBudgetById(@PathVariable Long id)
    {
        return budgetService.getBudgetById(id);
    }
    @PostMapping
    public Budget createBudget(@RequestBody Budget budget)
    {
        return budgetService.saveBudget(budget);
    }
    @PutMapping("/{id}")
    public Budget updateBudget(@PathVariable Long id, @RequestBody Budget budget)
    {
        return budgetService.updateBudget(id, budget);
    }
    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id)
    {
        budgetService.deleteBudget(id);
    }

    @GetMapping("paginate")
        public Page<Budget>getAllPage(Pageable pg)
        {
        return budgetService.getAllPage(pg);
        }

    @GetMapping("/category")
        public ResponseEntity<List<Budget>>findByCategory(@RequestParam String category)
        {
            return ResponseEntity.ok(budgetService.findByCategory(category));
        }
}