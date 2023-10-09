<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Khach Hang</title>
</head>
<body>
<div class="container">
    <h1 class="text-center"> Create Khách Hàng</h1>
    <sf:form action="/khach-hang/store" method="POST" modelAttribute="kh">
        <div>
            <label>Mã <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" cssClass="form-control" path="ma"/>
            <sf:errors cssClass="text-danger" path="ma"></sf:errors>
        </div>
        <div>
            <label>Họ <span class="text-danger">*</span></label>
            <sf:input type="text" name="ho" cssClass="form-control" path="ho"/>
            <sf:errors cssClass="text-danger" path="ho"></sf:errors>
        </div>
        <div>
            <label>Tên Đệm</label>
            <sf:input type="text" name="tenDem" cssClass="form-control" path="tenDem"/>
        </div>
        <div>
            <label>Tên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" cssClass="form-control" path="ten"/>
            <sf:errors cssClass="text-danger" path="ten"></sf:errors>
        </div>

        <div>
            <label>Ngày Sinh <span class="text-danger">*</span></label>
            <sf:input type="date" name="ngaySinh" cssClass="form-control" path="ngaySinh"/>
            <sf:errors cssClass="text-danger" path="ngaySinh"></sf:errors>
        </div>
        <div>
            <label>SDT <span class="text-danger">*</span></label>
            <sf:input type="number" name="sdt" cssClass="form-control" path="sdt"/>
            <sf:errors cssClass="text-danger" path="sdt"></sf:errors>
        </div>
        <div>
            <label>Địa chỉ <span class="text-danger">*</span></label>
            <sf:input type="text" name="diaChi" cssClass="form-control" path="diaChi"/>
            <sf:errors cssClass="text-danger" path="diaChi"></sf:errors>
        </div>
        <div>
            <label>Thành Phố <span class="text-danger">*</span></label>
            <sf:input type="text" name="thanhPho" cssClass="form-control" path="thanhPho"/>
            <sf:errors cssClass="text-danger" path="thanhPho"></sf:errors>
        </div>
        <div>
            <label>Quốc Gia <span class="text-danger">*</span></label>
            <sf:input type="text" name="quocGia" cssClass="form-control" path="quocGia"/>
            <sf:errors cssClass="text-danger" path="quocGia"></sf:errors>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-success">Submit</button>
        </div>
    </sf:form>
</div>
</body>
</html>