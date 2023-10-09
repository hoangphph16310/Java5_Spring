<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
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
    <C:if test="${not empty errorMessage}">
        <div class="alert alert-success d-flex align-items-center" role="alert">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
            </svg>
            <div>
                    ${errorMessage}
            </div>
        </div>
    </C:if>
    <h1 class="text-center">Create Chức Vụ</h1>
    <sf:form action="/chuc-vu/store" method="POST" modelAttribute="cv">
        <div>
            <label>Mã nhân viên <span class="text-danger">*</span></label>
            <sf:input type="text" name="ma" class="form-control" path="ma"/>
            <sf:errors path="ma" cssClass="text-danger"></sf:errors>
        </div>
        <div>
            <label>Tên nhân viên<span class="text-danger">*</span></label>
            <sf:input type="text" name="ten" class="form-control" path="ten"/>
            <sf:errors path="ten" cssClass="text-danger"></sf:errors>
        </div>
        <div class="text-center mt-3">
            <button class="btn btn-success">Submit</button>
        </div>
    </sf:form>
</div>
</body>
</html>