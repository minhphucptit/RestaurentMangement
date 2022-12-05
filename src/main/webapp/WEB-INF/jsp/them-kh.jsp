<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/static/ban.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%--@elvariable id="khachHang" type="java"--%>
    <form:form action="/khach-hangs/2/them-KH" method="POST" modelAttribute="khachHang">
        <h1>Thêm khách hàng</h1>
        <div class="form-group">
            <form:input  type="text"     path="ten"/>
            <label class="control-label" >Tên khách hàng</label>
            <i class="bar"></i>
            <%--            <i class="input-error">error here</i>--%>
        </div>
        <div class="form-group">
            <form:input  type="text"   path="email" />
            <label class="control-label" >Email</label>
            <i class="bar"></i>
            <%--            <i class="input-error">error here</i>--%>
        </div>
        <div class="form-group">
            <form:input type="text"  path="sdt" />
            <label class="control-label" >Số điện thoại</label>
            <i class="bar"></i>
            <%--            <i class="input-error">error here</i>--%>
        </div>
        <div class="form-group">
            <form:input type="text" path="diaChi" />
            <label class="control-label" >Địa chỉ</label>
            <i class="bar"></i>
            <%--            <i class="input-error">error here</i>--%>
        </div>
        <%--        <div class="form-group">--%>
        <%--            <textarea value="d" required="required"></textarea>--%>
        <%--            <label class="control-label" >Món ăn</label><i class="bar"></i>--%>
        <%--        </div>--%>
        <div class="button-container">
            <button class="button" type="submit"><span>Lưu</span></button>
        </div>
    </form:form>

</div>
<script src="../../static/home.js"></script>
</body>
</html>