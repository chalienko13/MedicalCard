<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Doctor page</title>

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
                <li><a href="/doctor/patientdoctor">Пацієнти</a></li>
                <li><a href="/doctor/map">Карта захворювань</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/"><button href="/" type="button" class="btn btn-default btn-sm">Вихід</button></a> </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>


<table class="table table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По батькові</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="patient" items="${patients}">
        <%--onclick="window.location.href='/patient'; return false"--%>
        <tr data-target="#myModal" class="id">
            <td>${patient.id}</td>
            <td>${patient.lastName}</td>
            <td>${patient.firstName}</td>
            <td>${patient.secondName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script>
    $(".id").on("click", function () {
        var id = $(this).closest("tr").find('td:eq(0)').html();
        document.location.href = "/patient?id=" + id;
    });
</script>
</html>
