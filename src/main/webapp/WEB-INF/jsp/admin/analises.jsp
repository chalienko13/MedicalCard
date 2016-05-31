<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chalienko
  Date: 11.05.2016
  Time: 01:36
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
            <a class="navbar-brand" href="#">Адміністратор системи </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/admin/department">Відділення</a></li>
                <li><a href="/admin/doctors">Лікарі</a></li>
                <li><a href="/admin/medicaments">Ліки</a></li>
                <li><a href="/admin/registers">Регістратори</a></li>
                <li class="active"><a href="/admin/analises">Аналізи</a></li>
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
            data-target="#addAnalises" class="btn btn-primary"
            type="button">Додати аналіз
    </button>
    <br>
</div>
<br>
<table class="table table-condensed table-hover col-md-8">
    <thead>
    <tr>
        <th>ID</th>
        <th>Назва аналізу</th>
        <th>Видалення</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="analis" items="${analises}">
        <tr data-target="#myModal" class="id">
            <td>${analis.id}</td>
            <td>${analis.analisesType}</td>
            <td>
                <button style="margin: 0" onclick="deleteAnalises('${analis.id}')"
                        class="btn btn-danger"
                        type="button">Видалити
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="addAnalises" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span></button>
            </div>
            <h4 class="modal-title">Додати аналіз</h4>
            <form action="addAnalises" method="post">
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
    function deleteAnalises(id) {
        console.log('In delete' + id);
        document.location.href = 'deleteAnalises?id=' + id;
    }
</script>

</html>