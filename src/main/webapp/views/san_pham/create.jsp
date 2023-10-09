<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
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
        <h1 class="text-center">Sản phẩm</h1>
    <sf:form action="/san-pham/store" method="POST" modelAttribute="sp">
        <div>
            <label>Mã <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" path="ma" class="form-control"/>
            <sf:errors path="ten" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>Tên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" path="ten" class="form-control"/>
            <sf:errors path="ten" cssClass="text-danger"></sf:errors>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-success">Add New</button>
        </div>
    </sf:form>
</div>
</body>
</html>