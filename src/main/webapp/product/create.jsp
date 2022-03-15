<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 15/03/2022
  Time: 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
</head>
<body>
<div class = "container">
    <h2>Thêm Sản Phẩm</h2>

    <form method="post" action="/products?action=create">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name:</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name = "name" aria-describedby="emailHelp">

        </div>
        <div class="mb-3">
            <label for="exampleInputEmail2" class="form-label">Price:</label>
            <input type="text" class="form-control" id="exampleInputEmail2" name="price" aria-describedby="emailHelp">

        </div>
        <div class="mb-3">
            <label for="exampleInputEmail5" class="form-label">Quantity:</label>
            <input type="text" class="form-control" id="exampleInputEmail5" name="quantity" value="${product.quantity}" aria-describedby="emailHelp" >

        </div>
        <div class="mb-3">
            <label for="exampleInputEmail3" class="form-label">Color:</label>
            <input type="text" class="form-control" id="exampleInputEmail3" name = "color" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail4" class="form-label">Descrition:</label>
            <input type="text" class="form-control" id="exampleInputEmail4" name = "description" aria-describedby="emailHelp">
        </div>
        <div class="input-group mb-3">
            <label class="input-group-text" for="inputGroupSelect01">Category:</label>
            <select class="form-control" class="form-select" id="inputGroupSelect01" name="categoryId">
<%--                <option value="${categories.id}" selected>Choice...</option>--%>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>


        <a href="/products?action=create"><button type="submit" class="btn btn-primary">Create</button></a>
        <i class="fas fa-grip-lines-vertical"></i>
        <a href="/products"><button  class="btn btn-secondary">Back</button></a>

    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
