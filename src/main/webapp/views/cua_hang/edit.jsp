<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Edit Cua Hang</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Edit Cửa Hàng</h1>
    <sf:form action="/cua-hang/update/${ch.ma}" method="POST" modelAttribute="ch">
        <div>
            <label>Mã <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" value="${ch.ma}" path="ma" cssClass="form-control"/>
            <sf:errors cssClass="text-danger" path="ma"></sf:errors>
        </div>
        <div>
            <label>Tên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" value="${ch.ten}" path="ten" cssClass="form-control"/>
            <sf:errors cssClass="text-danger" path="ten"></sf:errors>
        </div>
        <div>
            <label>Địa chỉ <span class="text-danger">*</span></label>
            <sf:input type="text" name="diaChi" value="${ch.diaChi}" path="diaChi" cssClass="form-control"/>
            <sf:errors cssClass="text-danger" path="diaChi"></sf:errors>
        </div>
        <div>
            <label>Thành Phố <span class="text-danger">*</span></label>
            <sf:input type="text" name="thanhPho" value="${ch.thanhPho}" path="thanhPho" cssClass="form-control"/>
            <sf:errors cssClass="text-danger" path="thanhPho"></sf:errors>
        </div>
        <div>
            <label>Quốc Gia <span class="text-danger">*</span></label>
            <sf:input type="text" name="quocGia" value="${ch.quocGia}" path="quocGia" cssClass="form-control"/>
            <sf:errors cssClass="text-danger" path="quocGia"></sf:errors>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-warning">Edit</button>
        </div>
    </sf:form>
</div>
</body>
</html>