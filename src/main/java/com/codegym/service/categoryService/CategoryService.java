package com.codegym.service.categoryService;

import com.codegym.dao.categoryDao.CategoryDao;
import com.codegym.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService {
    CategoryDao categoryDao;
    Category category;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() throws SQLException {

        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public boolean createProduct(Category category) throws SQLException {
        return false;
    }

    @Override
    public boolean updateProductById(int id, Category category) {
        return false;
    }

    @Override
    public boolean deleteProductById(int id) {
        return false;
    }
}
