package com.examly.springapp.controllers;
import com.examly.springapp.entities.FinancialGoal;
import com.examly.springapp.services.FinancialGoalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/financialgoals")
public class FinancialGoalController
{
    private final FinancialGoalService financialGoalService;
    public FinancialGoalController(FinancialGoalService financialGoalService)
    {
        this.financialGoalService = financialGoalService;
    }
    @PostMapping
    public FinancialGoal saveFinancialGoal(@RequestBody FinancialGoal financialGoal)
    {
        return financialGoalService.saveFinancialGoal(financialGoal);
    }
    @GetMapping
    public List<FinancialGoal> getAllFinancialGoals()
    {
        return financialGoalService.getAllFinancialGoals();
    }
    @GetMapping("/{id}")
    public FinancialGoal getFinancialGoalById(@PathVariable Long id)
    {
        return financialGoalService.getFinancialGoalById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public FinancialGoal updateFinancialGoal(@PathVariable Long id, @RequestBody FinancialGoal financialGoal)
    {
        return financialGoalService.updateFinancialGoal(id, financialGoal);
    }
    @DeleteMapping("/{id}")
    public String deleteFinancialGoal(@PathVariable Long id)
    {
        financialGoalService.deleteFinancialGoal(id);
        return "Deleted Successfully";
    }
    @GetMapping("paginate")
        public Page<FinancialGoal>getAllPage(Pageable pg)
        {
        return financialGoalService.getAllPage(pg);
        }
}