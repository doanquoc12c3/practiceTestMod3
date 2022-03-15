<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 15/03/2022
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
    <style>
        .container{
            margin-top: 5vw;
        }
    </style>
</head>
<body>
<div class = container>

    <div class = container>
        <h2>Product List</h2>
        <div class="row">
            <div class="col">
                <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                    <a href="/products?action=create"><button class="btn btn-primary me-md-2" type="button"><i class="fas fa-plus"></i> Add new product</button></a>
                </div>
            </div>
            <div class="col">
            <form action="/products?action=searchName" method="post">

                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <input type="text" class=" me-md-2" placeholder="Search" name="searchName">
                        <button class="btn btn-primary" ><i class="fas fa-search"></i> Search</button>
                    </div>
            </form>
            </div>

        </div>
        <br>
        <div class="card">
            <div class="card-header">
                <i class="far fa-list-alt"></i> Product List
            </div>
            <div class="card-body">
                <blockquote class="blockquote mb-0">
                    <table class = "table table-bordered" >
                        <thead>
                            <th>#</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Color</th>
                            <th>Description</th>
                            <th>Category</th>
                            <th colspan="2">Action</th>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${products}" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>${product.color}</td>
                                <td>${product.description}</td>
                                <td>${product.category}</td>
                                <td><a href="/products?action=edit&id=${product.id}"><button type="button" class="btn btn-primary"> <i class="far fa-edit"></i> Edit</button></a></td>
                                <td><a href="/products?action=delete&id=${product.id}"><button type="button" class="btn btn-danger"><i class="fas fa-eraser"></i> Delete</button></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>


                    </table>
                </blockquote>
            </div>
        </div>




    </div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
