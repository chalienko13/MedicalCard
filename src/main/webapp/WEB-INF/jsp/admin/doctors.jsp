<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chalienko
  Date: 11.05.2016
  Time: 01:35
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
            <a class="navbar-brand" href="#">Адміністратор системи</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/admin/department">Відділення</a></li>
                <li class="active"><a href="/admin/doctors">Лікарі</a></li>
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
    <ul class="list-inline">
        <li>
            <button style="margin-left: 20%" data-toggle="modal"
                    data-target="#addDoctor" class="btn btn-primary"
                    type="button">Додати лікаря
            </button>
        </li>

        <li style=" padding-left: 3%;">
            <input style="width: 100%;  " type="search" class="form-control" data-table="order-table" placeholder="Filter">
        </li>
    </ul>
    <br>
</div>
<br>
<table class="table table-condensed table-hover col-md-8 order-table table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Прізвище</th>
        <th>Ім'я</th>
        <th>По батькові</th>
        <th>Відділ</th>
        <th>Редагування</th>
        <th>Видалення</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${doctors}">
        <tr data-target="#myModal" class="id">
            <td>${user.id}</td>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.department.title}</td>
            <td>
                <button style="margin: 0" class="btn btn-link" type="button"
                        data-toggle="modal"
                        data-target="#addDoctor">
                    <span class="glyphicon glyphicon-edit"></span>
                </button>
            </td>
            <td>
                <button style="margin: 0" data-toggle="modal"
                        data-target="#deleteEmployee" onclick="deleteDoctors('${user.id}')" class="btn btn-danger"
                        type="button">Видалити
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<div id="addDoctor" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span></button>

                <h4 class="modal-title">Додати лікаря</h4>

                <div>
                    <form method="post">
                        <table class="table">
                            <tr>
                                <td> Ім'я</td>
                                <td><input type="text" name="firstName"></td>
                            </tr>
                            <tr>
                                <td> По батькові</td>
                                <td><input type="text" name="secondName"></td>
                            </tr>
                            <tr>
                                <td> Прізвище</td>
                                <td><input type="text" name="lastName"></td>
                            </tr>
                            <tr>
                                <td> Логін</td>
                                <td><input type="text" name="username"></td>
                            </tr>
                            <tr>
                                <td> Пароль</td>
                                <td><input type="password" name="password"></td>
                            </tr>
                            <tr>
                                <div class="form-group">
                                    <label for="sel1">Відділ:</label>
                                    <select class="form-control" name="department" id="sel1">
                                        <c:forEach var="department" items="${departments}">
                                            <option value="${department.id}">${department.title}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </tr>
                        </table>
                </div>
            </div>
            <div class="modal-footer">
                <input type="SUBMIT" class="btn btn-default" value="Додати">
            </div>
            </form>
        </div>

    </div>
</div>




<!-- modal dialog -->
<div id="editEmployee" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"></span></button>

                <h4 class="modal-title">Edit employee</h4>

                <div>
                    <table class="table">
                        <tr>
                            <td> First Name</td>
                            <td><input type="text" ng-model="firstNameEdit" id="firstNameEdit"></td>
                        </tr>
                        <tr>
                            <td> Second Name</td>
                            <td><input type="text" ng-model="secondNameEdit" id="secondNameEdit"></td>
                        </tr>
                        <tr>
                            <td> Last Name</td>
                            <td><input type="text" ng-model="lastNameEdit" id="lastNameEdit"></td>
                        </tr>
                        <tr>
                            <td> Email</td>
                            <td><input type="text" ng-model="emailEdit" id="emailEdit"></td>
                        </tr>
                        <tr>
                            <td> Role</td>
                            <td>
                                <input type="checkbox" id="techEdit" ng-model="techEdit" value="option1">
                                Tech </input>
                                <input type="checkbox" id="softEdit" ng-model="softEdit" value="option2">
                                Soft </input>
                                <input type="checkbox" id="adminEdit" ng-model="adminEdit" value="option3">
                                Administrator </input>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" ng-click="editEmployee()" type="button" id="saveChanges"
                        data-dismiss="modal">Save changes
                </button>
            </div>
        </div>

    </div>
</div>
</body>

<script>
    function deleteDoctors(id) {
        console.log('In delete' + id);
        document.location.href = 'deleteDoctor?id=' + id;
    }
    (function(document) {
        'use strict';

        var LightTableFilter = (function(Arr) {

            var _input;

            function _onInputEvent(e) {
                _input = e.target;
                var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                Arr.forEach.call(tables, function(table) {
                    Arr.forEach.call(table.tBodies, function(tbody) {
                        Arr.forEach.call(tbody.rows, _filter);
                    });
                });
            }

            function _filter(row) {
                var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
            }

            return {
                init: function() {
                    var inputs = document.getElementsByClassName('form-control');
                    Arr.forEach.call(inputs, function(input) {
                        input.oninput = _onInputEvent;
                    });
                }
            };
        })(Array.prototype);

        document.addEventListener('readystatechange', function() {
            if (document.readyState === 'complete') {
                LightTableFilter.init();
            }
        });

    })(document);
</script>
</html>
