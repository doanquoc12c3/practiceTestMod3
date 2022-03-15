package com.codegym.service.producService;

import com.codegym.dao.productDao.ProductDao;
import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService {
    ProductDao productDao;
    Product product;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        try {
            return productDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        try {
            return productDao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean createProduct(Product product) throws SQLException {
        return productDao.createProduct(product);
    }

    @Override
    public boolean updateProductById(int id, Product product) {
        return productDao.updateProductById(id,product);
    }

    @Override
    public boolean deleteProductById(int id) {

        return productDao.deleteProductById(id);
    }

    @Override
    public List<Product> searchProductName(String searchName) {
        searchName = "%"+searchName+"%";
        return productDao.searchProductName(searchName);
    }
}
