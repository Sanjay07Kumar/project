package com.examly.springapp.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class FinancialGoal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double targetAmount;
    private double currentAmount;
    private String deadline;
    public FinancialGoal() {}
    public FinancialGoal(String name, double targetAmount, double currentAmount, String deadline)
    {
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.deadline = deadline;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getTargetAmount()
    {
        return targetAmount;
    }
    public void setTargetAmount(double targetAmount)
    {
        this.targetAmount = targetAmount;
    }
    public double getCurrentAmount()
    {
        return currentAmount;
    }
    public void setCurrentAmount(double currentAmount)
    {
        this.currentAmount = currentAmount;
    }
    public String getDeadline()
    {
        return deadline;
    }
    public void setDeadline(String deadline)
    {
        this.deadline = deadline;
    }
}