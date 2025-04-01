package com.examly.springapp.services;
import com.examly.springapp.entities.Category;
import com.examly.springapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;
    public Category saveCategory(Category category)
    {
        return categoryRepository.save(category);
    }
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(Long id)
    {
        return categoryRepository.findById(id);
    }
    public void deleteCategory(Long id)
    {
        categoryRepository.deleteById(id);
    }
    public Page<Category> getAllPage(Pageable pg) 
    {
        return categoryRepository.findAll(pg);
    }
}