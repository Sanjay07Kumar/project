package com.examly.springapp.services;
import com.examly.springapp.entities.FinancialGoal;
import com.examly.springapp.repositories.FinancialGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class FinancialGoalService
{
    @Autowired
    private FinancialGoalRepository financialGoalRepository;
    public FinancialGoal saveFinancialGoal(FinancialGoal financialGoal)
    {
        return financialGoalRepository.save(financialGoal);
    }
    public List<FinancialGoal> getAllFinancialGoals()
    {
        return financialGoalRepository.findAll();
    }
    public Optional<FinancialGoal> getFinancialGoalById(Long id)
    {
        return financialGoalRepository.findById(id);
    }
    public void deleteFinancialGoal(Long id)
    {
        financialGoalRepository.deleteById(id);
    }
    public FinancialGoal updateFinancialGoal(Long id, FinancialGoal financialGoal)
    {
        return financialGoalRepository.findById(id)
                .map(existingGoal ->
                {
                    existingGoal.setName(financialGoal.getName());
                    existingGoal.setTargetAmount(financialGoal.getTargetAmount());
                    existingGoal.setDeadline(financialGoal.getDeadline());
                    return financialGoalRepository.save(existingGoal);
                })
                .orElseThrow(() -> new RuntimeException("Financial Goal not found with id " + id));
    }
     public Page<FinancialGoal> getAllPage(Pageable pg) 
    {
        return financialGoalRepository.findAll(pg);
    }
}