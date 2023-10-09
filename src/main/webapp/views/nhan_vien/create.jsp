<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Nhan Vien</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Create Nhan Vien</h1>
    <h2>Xin chào, ${nv.ten}</h2>
    <%--modelAttribute: lấy thuộc tính trong model và ràng buộc lên form--%>
    <sf:form action="/nhan-vien/store" method="POST" modelAttribute="nv">
        <div>
            <label>Mã <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" path="ma" cssClass="form-control"/>
            <sf:errors path="ma" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>Họ <span class="text-danger">*</span></label>
            <sf:input type="text" name="ho" path="ho" cssClass="form-control"/>
            <sf:errors path="ho" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>Tên Đệm</label>
            <sf:input type="text" name="tenDem" path="tenDem" cssClass="form-control"/>
        </div>
        <div>
            <label>Tên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" path="ten" cssClass="form-control"/>
            <sf:errors path="ten" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>Ngày sinh</label>
            <sf:input type="date" name="ngaySinh" path="ngaySinh" cssClass="form-control"/>
            <sf:errors path="ngaySinh" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>Giới tính</label>
            <div>
                <sf:radiobutton path="gioiTinh" value="1" checked="checked"/> <label>Nam</label>
                <sf:radiobutton path="gioiTinh" value="0"/> <label>Nữ</label>
                <sf:errors path="gioiTinh" cssClass="text-danger"></sf:errors>
            </div>
        </div>
        <div>
            <label>Địa chỉ</label>
            <sf:input type="text" name="diaChi" path="diaChi" cssClass="form-control"/>
            <sf:errors path="diaChi" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>SDT</label>
            <sf:input type="number" name="sdt" path="sdt" cssClass="form-control"/>
            <sf:errors path="sdt" cssClass="text-danger"></sf:errors>
        </div>
        <br>
        <div class="text-center">
            <button class="btn btn-success ">Submit</button>
        </div>
    </sf:form>
</div>
</body>
</html>