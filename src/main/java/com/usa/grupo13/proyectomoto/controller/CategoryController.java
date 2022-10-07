package com.usa.grupo13.proyectomoto.controller;


import com.usa.grupo13.proyectomoto.entities.Category;
import com.usa.grupo13.proyectomoto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId) {return categoryService.getCategory(categoryId);}
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c) {return categoryService.save(c);}
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category){return categoryService.update(category);}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") int categoryId){return categoryService.delete(categoryId);}
}
