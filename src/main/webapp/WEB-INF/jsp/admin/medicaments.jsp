<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chalienko
  Date: 11.05.2016
  Time: 01:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a class="navbar-brand" href="#">Адміністратор системи</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/admin/department">Відділення</a></li>
                <li><a href="/admin/doctors">Лікарі</a></li>
                <li class="active"><a href="/admin/medicaments">Ліки</a></li>
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
    <ul class="list-inline">
        <li>
            <button style="margin-left: 20%" data-toggle="modal"
                    data-target="#addMedicament" class="btn btn-primary"
                    type="button">Додати ліки
            </button>
        </li>
        <li style=" padding-left: 3%;">
            <input style="width: 100%;  " type="search" class="form-control" data-table="order-table"
                   placeholder="Filter">
        </li>
    </ul>
    <br>
</div>
<br>
<table class="table table-condensed table-hover col-md-8 order-table table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Назва</th>
        <th>Коментарій</th>
        <th>Видалити</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="medicament" items="${medicaments}">
        <tr data-target="#myModal" class="id">
            <td>${medicament.id}</td>
            <td>${medicament.title}</td>
            <td>${medicament.comments}</td>
            <td>
                <button style="margin: 0" data-toggle="modal"
                        data-target="#deleteMedicament" onclick="deleteMedicament('${medicament.id}')"
                        class="btn btn-danger"
                        type="button">Видалити
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="addMedicament" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span></button>
                <h4 class="modal-title">Додати ліки</h4>
                <div>
                    <form method="post">
                        <table class="table">
                            <tr>
                                <td> Назва</td>
                                <td><input type="text"   name="title"></td>
                            </tr>
                            <tr>
                                <td> Опис</td>
                                <td><textarea name="comment" cols="50" rows="4"></textarea></td>
                            </tr>
                        </table>
                        <div class="modal-footer">
                            <input type="SUBMIT" class="btn btn-default" value="Додати">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function deleteMedicament(id) {
        console.log('In delete' + id);
        document.location.href = 'deleteMedicament?id=' + id;
    }
    (function (document) {
        'use strict';

        var LightTableFilter = (function (Arr) {

            var _input;

            function _onInputEvent(e) {
                _input = e.target;
                var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                Arr.forEach.call(tables, function (table) {
                    Arr.forEach.call(table.tBodies, function (tbody) {
                        Arr.forEach.call(tbody.rows, _filter);
                    });
                });
            }

            function _filter(row) {
                var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
            }

            return {
                init: function () {
                    var inputs = document.getElementsByClassName('form-control');
                    Arr.forEach.call(inputs, function (input) {
                        input.oninput = _onInputEvent;
                    });
                }
            };
        })(Array.prototype);

        document.addEventListener('readystatechange', function () {
            if (document.readyState === 'complete') {
                LightTableFilter.init();
            }
        });

    })(document);
</script>
</body>
</html>