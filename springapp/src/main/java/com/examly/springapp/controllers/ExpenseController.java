package com.examly.springapp.controllers;
import com.examly.springapp.entities.Expense;
import com.examly.springapp.services.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("expenses")
public class ExpenseController
{
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService)
    {
        this.expenseService = expenseService;
    }
    @GetMapping
    public List<Expense> getAllExpenses()
    {
        return expenseService.getAllExpenses();
    }
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id)
    {
        return expenseService.getExpenseById(id).orElse(null);
    }
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense)
    {
        return expenseService.addExpense(expense);
    }
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expenseDetails)
    {
        return expenseService.updateExpense(id, expenseDetails);
    }
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id)
    {
        expenseService.deleteExpense(id);
        return "Deleted Successfully";
    }
    @GetMapping("paginate")
        public Page<Expense>getAllPage(Pageable pg)
        {
        return expenseService.getAllPage(pg);
        }
}