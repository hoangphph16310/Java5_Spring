<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!doctype html>
<html lang="en">
<head>
    <title>Page Khach Hang</title>
</head>
<body>
<div class="container">

    <h1 class="text-center">Danh Sách Khách Hàng</h1>
    <div class="mb-2">
        <button class="btn btn-success"><a href="/khach-hang/create"
                                           class="text-decoration-none text-light">Add New</a></button>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Mã</th>
            <th>Họ</th>
            <th>Tên Đệm</th>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>SDT</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${data}" var="kh">
            <tr>
                <td>${kh.ma}</td>
                <td>${kh.ho}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ten}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.sdt}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>
                    <button class="btn btn-info"><a href="/khach-hang/edit/${kh.ma}" class="text-decoration-none text-dark">Update</a></button>
                    <button class="btn btn-danger"><a href="/khach-hang/delete/${kh.ma}" class="text-decoration-none text-dark">Delete</a></button>
                </td>

            </tr>
        </C:forEach>
        </tbody>
    </table>
</div>
</body>
</html>