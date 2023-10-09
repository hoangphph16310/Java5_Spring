<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Mau Sac</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Create Màu Sắc</h1>
    <sf:form action="/mau-sac/store" method="POST" modelAttribute="ms" >
        <div>
            <label>Mã <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" path="ma" class="form-control"/>
            <sf:errors cssClass="text-danger" path="ma"></sf:errors>
        </div>
        <div>
            <label>Tên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" path="ten" class="form-control"/>
            <sf:errors cssClass="text-danger" path="ten"></sf:errors>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-success">Submit</button>
        </div>
    </sf:form>
</div>
</body>
</html>