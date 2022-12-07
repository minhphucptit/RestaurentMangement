<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.restaurentmangement.dao.BanDao" %>
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
    <div class="flex-container">
        <div>
            <input class="form-control" id="customerInput" type="text" placeholder="Số ghế..">
        </div>
        <div>
            <input class="form-control" id="seatInput" type="text" placeholder="Tên khách hàng..">
        </div>
        <div>
            <input class="form-control" type="datetime-local" id="date" name="birthdaytime">
        </div>
        <div>
            <select class="form-control" name="cars" id="status">
                <option value="2">Tất cả</option>
                <option value="1">Đã đặt</option>
                <option value="0">Trống</option>
            </select>
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
                <th>Tên Bàn</th>
                <th>Số ghế</th>
                <th>Trạng thái</th>
                <th>Người đặt</th>
                <th>Thời gian đặt</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <% int stt = 1; %>
            <c:forEach items="${bans}" var="ban">
                <tr>
                    <td data-title="ID"><%= stt++%>
                    </td>
                    <td data-title="Name">${ban.tenBan}</td>
                    <td data-title="Link">
                            ${ban.soGhe}
                    </td>
                    <td data-title="Status">${ban.trangThai == 0 ? "Trống" : "Đã đặt"}</td>
                    <td data-title="button">
                            ${ban.tenKH}
                    </td>
                    <td>
                            ${ban.getThoiGianDat1()}
                    </td>
                    <td >
                        <c:if test="${ban.tenKH == null}">
                        <button><a href="/khach-hangs/${ban.banId}">Đặt</a></button>
                        </c:if>
                        <c:if test="${ban.trangThai == 1}">
                            <button>Thanh toán</button>
                        </c:if>
                        <c:if test="${ban.trangThai == 1}">
                            <button>Gọi món</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>
</div>
<script src="../../static/home.js"></script>
</body>
</html>