<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!doctype html>
<html lang="en">
<head>
    <title>Page Index Nhan Vien</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Danh sách nhân viên</h1>
    <div class="mb-2">
        <button class="btn btn-success"><a href="/nhan-vien/create"
                                           class="text-decoration-none text-light">Add New</a></button>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Họ</th>
            <th>Tên Đệm</th>
            <th>Tên</th>
            <th>Gioi Tinh</th>
            <th>Ngày sinh</th>
            <th>Mật Khẩu</th>
            <th>Địa chỉ</th>
            <th>SDT</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${data}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ho}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.ten}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.sdt}</td>
                <td>
                    <button class="btn btn-info"><a href="/nhan-vien/edit/${nv.ma}"
                                                    class="text-decoration-none text-dark">Update</a></button>
                    <button class="btn btn-danger"><a href="/nhan-vien/delete/${nv.ma}"
                                                      class="text-decoration-none text-dark">Delete</a></button>
                </td>
            </tr>
        </C:forEach>
        </tbody>
    </table>
</div>
</body>
</html>