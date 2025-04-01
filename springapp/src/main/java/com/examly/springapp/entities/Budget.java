package com.examly.springapp.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Budget
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private double allocatedamount;
    private String startdate;
    private String enddate;
    private String status;

    public Budget() {}
    public Budget(String category, double allocatedamount)
    {
        this.category = category;
        this.allocatedamount = allocatedamount;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    public double getAllocatedAmount()
    {
        return allocatedamount;
    }
    public void setAllocatedAmount(double allocatedamount)
    {
        this.allocatedamount = allocatedamount;
    }
    public String getStartDate()
    {
        return startdate;
    }
    public void setStartDate(String startdate)
    {
        this.startdate = startdate;
    }
    public String getEndDate()
    {
        return enddate;
    }
    public void setEndDate(String enddate)
    {
        this.enddate = enddate;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}