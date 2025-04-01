package com.examly.springapp.repositories;
import com.examly.springapp.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>
{
    
}
