package com.codegym.service;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll() throws SQLException;
    T findById(int id);
    boolean createProduct(T t) throws SQLException;
    boolean updateProductById(int id, T t);
    boolean deleteProductById(int id);

}
