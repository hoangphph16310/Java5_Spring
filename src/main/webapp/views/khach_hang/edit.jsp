<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Edit Khach Hang</title>
</head>
<body>
<div class="container">
    <h1 class="text-center"> Edit Khách Hàng</h1>
    <sf:form action="/khach-hang/update/${kh.ma}" method="POST" modelAttribute="kh">
        <div>
            <label>Mã <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" cssClass="form-control" path="ma" value="${kh.ma}"/>
            <sf:errors cssClass="text-danger" path="ma"></sf:errors>
        </div>
        <div>
            <label>Họ</label>
            <sf:input type="text" name="ho" cssClass="form-control" path="ho" value="${kh.ho}"/>
            <sf:errors cssClass="text-danger" path="ho"></sf:errors>
        </div>
        <div>
            <label>Tên Đệm <span class="text-danger">*</span></label>
            <sf:input type="text" name="tenDem" cssClass="form-control" path="tenDem" value="${kh.tenDem}"/>
            <sf:errors cssClass="text-danger" path="tenDem"></sf:errors>
        </div>
        <div>
            <label>Tên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" cssClass="form-control" path="ten" value="${kh.ten}"/>
            <sf:errors cssClass="text-danger" path="ten"></sf:errors>
        </div>
        <div>
            <label>Ngày Sinh <span class="text-danger">*</span></label>
            <sf:input type="date" name="ngaySinh" cssClass="form-control" path="ngaySinh" value="${kh.ngaySinh}"/>
            <sf:errors cssClass="text-danger" path="ngaySinh"></sf:errors>
        </div>
        <div>
            <label>SDT <span class="text-danger">*</span></label>
            <sf:input type="number" name="sdt" cssClass="form-control" path="sdt" value="${kh.sdt}"/>
            <sf:errors cssClass="text-danger" path="sdt"></sf:errors>
        </div>
        <div>
            <label>Địa chỉ <span class="text-danger">*</span></label>
            <sf:input type="text" name="diaChi" cssClass="form-control" path="diaChi" value="${kh.diaChi}"/>
            <sf:errors cssClass="text-danger" path="diaChi"></sf:errors>
        </div>
        <div>
            <label>Thành Phố <span class="text-danger">*</span></label>
            <sf:input type="text" name="thanhPho" cssClass="form-control" path="thanhPho" value="${kh.thanhPho}"/>
            <sf:errors cssClass="text-danger" path="thanhPho"></sf:errors>
        </div>
        <div>
            <label>Quốc Gia <span class="text-danger">*</span></label>
            <sf:input type="text" name="quocGia" cssClass="form-control" path="quocGia" value="${kh.quocGia}"/>
            <sf:errors cssClass="text-danger" path="quocGia"></sf:errors>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-warning">Edit</button>
        </div>
    </sf:form>
</div>
</body>
</html>