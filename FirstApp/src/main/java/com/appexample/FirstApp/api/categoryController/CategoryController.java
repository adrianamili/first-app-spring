package com.appexample.FirstApp.api.categoryController;

import com.appexample.FirstApp.api.DTO.categoryDTO.CategoryDTOadd;
import com.appexample.FirstApp.domain.category.Category;
import com.appexample.FirstApp.domain.category.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/add")
    Category addCategory(@RequestBody CategoryDTOadd categoryDTOadd){
        Category categoryAdded = new Category();
        categoryAdded.setId(categoryDTOadd.getId());
        categoryAdded.setName(categoryDTOadd.getName());
        
        return categoryRepository.save(categoryAdded);
    }
}
