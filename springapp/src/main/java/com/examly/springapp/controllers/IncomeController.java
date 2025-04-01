package com.examly.springapp.controllers;
import com.examly.springapp.entities.Income;
import com.examly.springapp.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/income")
public class IncomeController
{
    @Autowired
    private IncomeService incomeService;
    @PostMapping
    public ResponseEntity<Income> saveIncome(@RequestBody Income income)
    {
        return ResponseEntity.ok(incomeService.saveIncome(income));
    }
    @GetMapping
    public ResponseEntity<List<Income>> getAllIncomes()
    {
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id)
    {
        Optional<Income> income = incomeService.getIncomeById(id);
        return income.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income)
    {
        Income updatedIncome = incomeService.updateIncome(id, income);
        return ResponseEntity.ok(updatedIncome);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id)
    {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("paginate")
        public Page<Income>getAllPage(Pageable pg)
        {
        return incomeService.getAllPage(pg);
        }
}