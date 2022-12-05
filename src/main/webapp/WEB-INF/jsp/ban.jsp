<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form>
        <h1>Chi tiết bàn</h1>
        <div class="form-group">
            <input required type="text"   disabled />
            <label class="control-label" >Tên bàn: "${ban.name}"</label>
            <i class="bar"></i>
            <%--            <i class="input-error">error here</i>--%>
        </div>
        <div class="form-group">
            <input required type="text"   disabled />
            <label class="control-label" >Số ghế: ${ban.soGhe}</label>
            <i class="bar"></i>
            <%--            <i class="input-error">error here</i>--%>
        </div>
        <div class="form-group">
            <input type="text"   disabled/>
            <label class="control-label" >Tên khách hàng: ${kh.ten}</label>
            <i class="bar"></i>
<%--            <i class="input-error">error here</i>--%>
        </div>
        <div class="form-group">
            <input type="datetime-local" required="required" disabled/>
            <label class="control-label" >Thời gian đặt: ${date}</label>
            <i class="bar"></i>
<%--            <i class="input-error">error here</i>--%>
        </div>
<%--        <div class="form-group">--%>
<%--            <textarea value="d" required="required"></textarea>--%>
<%--            <label class="control-label" >Món ăn</label><i class="bar"></i>--%>
<%--        </div>--%>

    </form>
    <div class="button-container">
        <button class="button" type="button"><span><a href="/bans/${ban.id}/khach-hang/${kh.id}/dat">Lưu</a></span></button>
    </div>
</div>
<script src="../../static/home.js"></script>
</body>
</html>