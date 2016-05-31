<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chalienko
  Date: 11.05.2016
  Time: 01:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="../../../resources/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="../../../resources/css/navbar-fixed-top.css" />" rel="stylesheet">
    <link href="<c:url value="../../../resources/css/doctor.css" />" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../../../resources/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${user.firstName} ${user.lastName}</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/admin/department">Відділення</a></li>
                <li><a href="/admin/doctors">Лікарі</a></li>
                <li><a href="/admin/medicaments">Ліки</a></li>
                <li><a href="/admin/registers">Регістратори</a></li>
                <li><a href="/admin/analises">Аналізи</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/exit">
                    <button href="/" type="button" class="btn btn-default btn-sm">Вихід</button>
                </a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div>
    <button style="margin-left: 20%" data-toggle="modal"
            data-target="#addDepartment" class="btn btn-primary"
            type="button">Додати відділ
    </button>
    <br>
</div>
<br>
<table class="table table-condensed table-hover col-md-8">
    <thead>
    <tr>
        <th>ID</th>
        <th>Відділ</th>
        <th>Список лікарів</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${departments}">
        <tr data-target="#myModal" class="id">
            <td>${department.id}</td>
            <td>${department.title}</td>
            <td>
                <ul>
                    <c:forEach var="user" items="${department.users}">
                        <li>${user.firstName} ${user.lastName}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <button style="margin: 0" data-toggle="modal"
                        data-target="#deleteEmployee" onclick="deleteDepartment('${department.id}')"
                        class="btn btn-danger"
                        type="button">Видалити
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="addDepartment" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span
                    ></button>
            </div>
            <h4 class="modal-title">Додати відділ</h4>
                <form action="addDepartment" method="post">
                    <div>
                        <table class="table">
                            <tr>
                                <td> Назва</td>
                                <td><input type="text" name="title"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <input type="submit" class="btn btn-default" value="Додати">
                    </div>
                </form>
        </div>
    </div>
</div>

</body>
<script>
    function deleteDepartment(id) {
        console.log('In delete' + id);
        document.location.href = 'deleteDepartment?id=' + id;
    }
</script>

</html>
