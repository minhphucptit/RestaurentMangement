<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Unik</title>
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/static/home.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

</div>
<div id="demo">
    <h1>Nhà hàng Unik</h1>
    <h2>Chỉ cần là bạn thích - có ngay món ngon</h2>
    <h2>Danh sách khach hàng</h2>
    <div>
        <button id="add" class="button-28" role="button"><a href="/khach-hangs/${banId}/them-KH">Thêm khách hàng</a></button>
    </div>
    <div class="flex-container">

        <div>
            <input class="form-control" id="name" type="text" placeholder="Tên khách hàng..">
        </div>
        <div>
            <input class="form-control" id="sdt" type="text" placeholder="Số điện thoại..">
        </div>
        <div>
            <button id="search" class="button-28" role="button">Search</button>
        </div>

    </div>


    <!-- Responsive table starts here -->
    <!-- For correct display on small screens you must add 'data-title' to each 'td' in your table -->
    <div class="table-responsive-vertical shadow-z-1">

        <!-- Table starts here -->
        <table id="table" class="table table-hover table-mc-light-blue">
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên Khách hàng</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Địa chỉ</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <% int stt = 1; %>
            <c:forEach items="${khs}" var="kh">
                <tr>
                    <td data-title="ID"><%= stt++%>
                    </td>
                    <td data-title="Name">${kh.ten}</td>
                    <td data-title="Link">
                            ${kh.email}
                    </td>
                    <td data-title="Status">${kh.sdt}</td>
                    <td data-title="button">
                            ${kh.diaChi}
                    </td>

                    <td >
                        <button><a href="/ban-dat/khach-hang/${kh.id}">Chọn</a></button>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>
</div>
<script src="../../static/khach-hangs.js"></script>
</body>
</html>