package com.codegym.dao.categoryDao;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;
import com.codegym.service.categoryService.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryService {
    private Connection connection = DBConnection.getConnection();

    public CategoryDao() throws SQLException, ClassNotFoundException {
    }

    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        Category category;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            category= new Category(id,name);
            categoryList.add(category);
        }
        return categoryList ;
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
