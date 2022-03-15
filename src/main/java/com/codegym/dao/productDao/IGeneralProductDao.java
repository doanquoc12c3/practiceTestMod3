package com.codegym.dao.productDao;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralProductDao extends IGeneralDao<Product> {
    @Override
    List<Product> findAll() throws SQLException, ClassNotFoundException;

    @Override
    Product findById(int id) throws SQLException, ClassNotFoundException;

    @Override
    boolean createProduct(Product product) throws SQLException;

    @Override
    boolean updateProductById(int id, Product product);

    @Override
    boolean deleteProductById(int id);

    List<Product> searchProductName(String searchName);
}