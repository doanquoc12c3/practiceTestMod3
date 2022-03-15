package com.codegym.controller;

import com.codegym.dao.categoryDao.CategoryDao;
import com.codegym.dao.productDao.ProductDao;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.categoryService.CategoryService;
import com.codegym.service.categoryService.ICategoryService;
import com.codegym.service.producService.IProductService;
import com.codegym.service.producService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService;
    ICategoryService categoryService;
    public ProductServlet() throws SQLException, ClassNotFoundException {
        this.productService = new ProductService(new ProductDao());
        this.categoryService = new CategoryService(new CategoryDao());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "create":
                try {
                    showCreateForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    showDeleteForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showListProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryService.findAll();
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        request.setAttribute("categories",categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryService.findAll();
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        request.setAttribute("categories",categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryService.findAll();
        request.setAttribute("categories",categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> productList = new ArrayList<>();
        productList = productService.findAll();
        request.setAttribute("products",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/list.jsp");
        requestDispatcher.forward(request, response);
    }







    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
        switch(action){
            case "create":
                try {
                    createProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                productService.deleteProductById(id);
                response.sendRedirect("/products");
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product(name,price,color,description,categoryId);
        productService.updateProductById(id, product);

        response.sendRedirect("/products");
    }

    private void createProduct(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException {
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(name, price, color, description, categoryId);

        productService.createProduct(product);

        response.sendRedirect("/products");
    }
}
