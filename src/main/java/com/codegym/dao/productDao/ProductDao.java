package com.codegym.dao.productDao;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IGeneralProductDao {
    private Connection connection;

    {
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductDao() {
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<>();
        Product product;

        PreparedStatement preparedStatement = connection.prepareStatement("select * from product join category on product.categoryId = category.id");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Double price = resultSet.getDouble(3);
            String color = resultSet.getString(4);
            String description = resultSet.getString(5);
            String category = resultSet.getString(8);
            product = new Product(id,name, price,color,description,category);
            productList.add(product);
        }
        return productList ;
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        Product product;

        PreparedStatement preparedStatement = connection.prepareStatement("select * from product join category on product.categoryId = category.id where product.id = ?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int id1 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Double price = resultSet.getDouble(3);
            String color = resultSet.getString(4);
            String description = resultSet.getString(5);
            int categoryId = resultSet.getInt(7);
            String category = resultSet.getString(8);
            product = new Product(id1,name, price, color, description, category,categoryId);
            return product;
        }
        return null;
    }

    @Override
    public boolean createProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price, color, description, categoryId) values(?,?,?,?,?)");
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getColor());
        preparedStatement.setString(4, product.getDescription());
        preparedStatement.setInt(5, product.getCategoryId());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateProductById(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?, price = ?, color =?, description = ?, categoryId = ? where id = ?");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setString(4,product.getDescription());
            preparedStatement.setInt(5,product.getCategoryId());
            preparedStatement.setInt(6,id);
            return  preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteProductById(int id) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from product where id = ?");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
