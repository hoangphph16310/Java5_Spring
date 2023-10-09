<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!doctype html>
<html lang="en">
<head>
    <title>Page Nha SX</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Danh Sách Nhà Sản Xuất</h1>
    <div class="mb-2">
        <button class="btn btn-success"><a href="/nhasx/create"
                                           class="text-decoration-none text-light">Add New</a></button>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${data}" var="nsx">
            <tr>
                <td>${nsx.ma}</td>
                <td>${nsx.ten}</td>
                <td>
                    <button class="btn btn-info"><a href="/nhasx/edit/${nsx.ma}" class="text-decoration-none text-dark">Update</a></button>
                    <button class="btn btn-danger"><a href="/nhasx/delete/${nsx.ma}" class="text-decoration-none text-dark">Delete</a></button>
                </td>
            </tr>
        </C:forEach>
        </tbody>
    </table>
</div>
</body>
</html>