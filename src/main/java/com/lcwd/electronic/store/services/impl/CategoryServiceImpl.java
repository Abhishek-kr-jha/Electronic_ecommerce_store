package com.lcwd.electronic.store.services.impl;

import com.lcwd.electronic.store.dtos.CategoryDto;
import com.lcwd.electronic.store.dtos.PageableResponse;
import com.lcwd.electronic.store.entities.Category;
import com.lcwd.electronic.store.exceptions.ResourceNotFoundException;
import com.lcwd.electronic.store.helper.Helper;
import com.lcwd.electronic.store.repositories.CategoryRepository;
import com.lcwd.electronic.store.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        //creating category id

        String categoryId = UUID.randomUUID().toString();
        categoryDto.setCategoryId(categoryId);

        // DTO → Entity
        Category category = mapper.map(categoryDto, Category.class);

        // Save Entity
        Category savedCategory = categoryRepository.save(category);

        // Entity → DTO
        return mapper.map(savedCategory, CategoryDto.class);
    }


    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {
        //get category of given id
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found Exception"));
        // update Category Details
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        category.setCoverImage(categoryDto.getCoverImage());

        Category updatedCategory = categoryRepository.save(category);


        return mapper.map(updatedCategory, CategoryDto.class);

    }

    @Override
    public void delete(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found Exception"));
        categoryRepository.delete(category);

    }

    @Override
    public PageableResponse<CategoryDto> getAll(
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortDir
    ) {

        Sort sortObj = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sortObj);

        Page<Category> page = categoryRepository.findAll(pageable);

        return Helper.getPageableResponse(page, CategoryDto.class);
    }

    @Override
    public CategoryDto get(String categoryId) {
        return null;
    }
}
