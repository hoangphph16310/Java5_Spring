<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Edit Nhan Vien</title>
</head>
<body>
<div class="container">

    <h1 class="text-center">Edit Nhan Vien</h1>
    <sf:form action="/nhan-vien/update/${nv.ma}" method="POST" modelAttribute="nv">
        <div>
            <label>Mã</label>
            <sf:input type="text" name="ma" path="ma" class="form-control"/>

        </div>
        <div>
            <label>Họ</label>
            <sf:input type="text" name="ho" path="ho" class="form-control"/>

        </div>
        <div>
            <label>Tên Đệm</label>
            <sf:input type="text" name="tenDem" path="tenDem" class="form-control"/>

        </div>
        <div>
            <label>Tên</label>
            <sf:input type="text" name="ten" path="ten" class="form-control"/>

        </div>
        <div>
            <label>Ngày sinh</label>
            <sf:input type="date" name="ngaySinh" path="ngaySinh" class="form-control"/>

        </div>
        <div>
            <label>Giới tính</label>
            <div>
                <sf:radiobutton path="gioiTinh" value="1" checked="checked"/> <label>Nam</label>
                <sf:radiobutton path="gioiTinh" value="0"/> <label>Nữ</label>
            </div>
        </div>
        <div>
            <label>Địa chỉ</label>
            <sf:input type="text" name="diaChi" path="diaChi" class="form-control"/>

        </div>
        <div>
            <label>SDT</label>
            <sf:input type="number" name="sdt" path="sdt" class="form-control"/>

        </div>
        <div class="text-center">
            <button class="btn btn-warning">Edit</button>
        </div>
    </sf:form>
</div>
</body>
</html>