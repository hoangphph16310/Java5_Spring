<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Danh sách dòng sản phẩm</h1>
    <div class="mb-2">
        <button class="btn btn-success"><a href="/dongsp/create"
                                           class="text-decoration-none text-light">Add New</a></button>
    </div>
    <table class="table table-bordered">
        <thead>
        <th>Mã</th>
        <th>Tên</th>
        <th>Hành Động</th>
        </thead>
        <tbody>
        <c:forEach items="${data}" var="dsp">
            <tr>
                <td>${dsp.ma}</td>
                <td>${dsp.ten}</td>
                <td>
                    <button class="btn btn-info"><a href="/dongsp/edit/${dsp.ma}" class="text-decoration-none text-dark">Update</a></button>
                    <button class="btn btn-danger"><a href="/dongsp/delete/${dsp.ma}" class="text-decoration-none text-dark">Delete</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>