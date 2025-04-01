package com.examly.springapp.services;
import com.examly.springapp.entities.Income;
import com.examly.springapp.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class IncomeService
{
    @Autowired
    private IncomeRepository incomeRepository;
    public Income saveIncome(Income income)
    {
        return incomeRepository.save(income);
    }
    public List<Income> getAllIncomes()
    {
        return incomeRepository.findAll();
    }
    public Optional<Income> getIncomeById(Long id)
    {
        return incomeRepository.findById(id);
    }
    public Income updateIncome(Long id, Income income)
    {
        return incomeRepository.findById(id)
                .map(existingIncome ->
                {
                    existingIncome.setAmount(income.getAmount());
                    existingIncome.setSource(income.getSource());
                    existingIncome.setDate(income.getDate());
                    return incomeRepository.save(existingIncome);
                })
                .orElseThrow(() -> new RuntimeException("Income not found with id " + id));
    }
    public void deleteIncome(Long id)
    {
        incomeRepository.deleteById(id);
    }
     public Page<Income> getAllPage(Pageable pg) 
    {
        return incomeRepository.findAll(pg);
    }
}