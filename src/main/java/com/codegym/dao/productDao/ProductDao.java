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
            int quantity = resultSet.getInt(4);
            String color = resultSet.getString(5);
            String description = resultSet.getString(6);
            String category = resultSet.getString(9);
            product = new Product(id,name, price,quantity,color,description,category);
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
            int quantity = resultSet.getInt(4);
            String color = resultSet.getString(5);
            String description = resultSet.getString(6);
            int categoryId = resultSet.getInt(8);
            String category = resultSet.getString(9);
            product = new Product(id1,name, price,quantity, color, description, category,categoryId);
            return product;
        }
        return null;
    }

    @Override
    public boolean createProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price, quantity,color, description, categoryId) values(?,?,?,?,?,?)");
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setString(3, product.getColor());
        preparedStatement.setInt(4,product.getQuantity());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setInt(6, product.getCategoryId());

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean updateProductById(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?, price = ?,quantity=? ,color =?, description = ?, categoryId = ? where id = ?");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategoryId());
            preparedStatement.setInt(7,id);
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

    @Override
    public List<Product> searchProductName(String searchName) {
        try {
            Product product;
            List<Product> products = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product join category on product.categoryId = category.id where product.name like ?");
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id1 = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String description = resultSet.getString(6);
                int categoryId = resultSet.getInt(8);
                String category = resultSet.getString(9);
                product = new Product(id1,name, price,quantity, color, description, category,categoryId);
                products.add(product);

            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
