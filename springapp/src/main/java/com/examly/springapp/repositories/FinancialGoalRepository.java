package com.examly.springapp.repositories;
import com.examly.springapp.entities.FinancialGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FinancialGoalRepository extends JpaRepository<FinancialGoal, Long>
{
    
}
