package com.codegym.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralDao<T> {
    List<T> findAll() throws SQLException, ClassNotFoundException;
    T findById(int id) throws SQLException, ClassNotFoundException;
    boolean createProduct(T t) throws SQLException;
    boolean updateProductById(int id, T t);
    boolean deleteProductById(int id);

}
