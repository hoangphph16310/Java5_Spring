<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!doctype html>
<html lang="en">
<head>
    <title>Page Chuc Vu</title>
</head>
<body>
<div class="container">
    <C:if test="${not empty successMessage}">
        <div class="alert alert-success d-flex align-items-center" role="alert">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
            </svg>
            <div>
               ${successMessage}
            </div>
        </div>
    </C:if>
  <div class="text-center">
      <h1>Danh Sách Chức Vụ</h1>
  </div>
    <div class="mb-2">
        <button class="btn btn-success"><a href="/chuc-vu/create"
                                                class="text-decoration-none text-light">Add New</a></button>
    </div>
    <div>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Tên</th>
                <th>Hành Động</th>
            </tr>
            </thead>
            <tbody>
            <C:forEach items="${data}" var="cv">
                <tr>
                    <td>${cv.ma}</td>
                    <td>${cv.ten}</td>
                    <td>
                        <button class="btn btn-info"><a href="/chuc-vu/edit/${cv.ma}"
                                                        class="text-decoration-none text-dark">Update</a></button>
                        <button class="btn btn-danger"><a href="/chuc-vu/delete/${cv.ma}"
                                                          class="text-decoration-none text-dark">Delete</a></button>
                    </td>
                </tr>
            </C:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>