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
    <link href="<c:url value="../../../resources/css/registrate.css" />" rel="stylesheet">
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
            <a class="navbar-brand" href="#">Регістратура</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/">
                <button href="/" type="button" class="btn btn-default btn-sm">Вихід</button>
            </a></li>
        </ul>
    </div>
</div>
<div>
    <h2 align="center">Реєстрація нового пацієнта:</h2>
    <form method="post">
        <table class="table table-hover">
            <tr>
                <th>Прізвище</th>
                <th><input type="text" required placeholder="Прізвище" name="lastName"></th>
                <th>Ім'я</th>
                <th><input type="text" required placeholder="Ім'я" name="firstName"></th>
                <th>По батькові</th>
                <th><input type="text" required placeholder="По батькові" name="secondName"></th>
                <th>Вік</th>
                <th><input type="text" required placeholder="25" name="age"></th>
                <th>Стать</th>
                <th>
                    <select name="sex">
                        <option value="man">Чоловіча</option>
                        <option value="woman">Жіноча</option>
                    </select>
                </th>
            </tr>
            <tr>
                <th>Адреса</th>
                <th><input type="text" required placeholder="проспект перемоги, 78, Київ" value="" name="address"></th>
                <th>Телефон</th>
                <th><input type="text" required placeholder="0732334565" name="phone"></th>
                <th>Номер АК</th>
                <th><input type="text" required placeholder="АК111111" name="numberAK"></th>
                <th>Дата</th>
                <th><input type="date" required placeholder="Дата" name="registrationDate"></th>
                <th>Ріст</th>
                <th><input type="text" placeholder="190" name="height"></th>


            </tr>
            <tr>
                <th>Вага</th>
                <th><input type="text"  placeholder="85" name="weight"></th>
                <th>Лікар: </th>
                <th>
                    <!--<div class="form-group">-->
                        <select class="form-control" name="doctor" id="sel1">
                            <c:forEach var="doctor" items="${doctors}">
                                <option value="${doctor.id}">${doctor.firstName} ${doctor.lastName} Відділ:
                                ${doctor.department.title}  </option>
                            </c:forEach>
                        </select>
                    <!--</div>-->
                </th>
            </tr>
        </table>
        <input type="submit" class="btn btn-default btn-sm" value="Зареєструвати">
    </form>
</div>
</body>
</html>
