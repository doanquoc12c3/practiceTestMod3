package com.codegym.service.producService;

import com.codegym.model.Product;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> searchProductName(String searchName);
}
