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
    <link href="<c:url value="../../../resources/css/patient.css" />" rel="stylesheet">
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
            <a class="navbar-brand" href="/r">${patient.firstName} ${patient.lastName}</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/doctor/patientdoctor">
                    <button type="button" class="btn btn-default btn-sm">Назад</button>
                </a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>

</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">${patient.firstName} ${patient.lastName}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic"
                                                                            src="http://png.clipart.me/graphics/thumbs/151/man-avatar-profile-picture-vector_151265384.jpg"
                                                                            class="img-circle img-responsive"></div>

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Ім'я:</td>
                                    <td>${patient.firstName}</td>
                                </tr>
                                <tr>
                                    <td>По батькові:</td>
                                    <td>${patient.secondName}</td>
                                </tr>
                                <tr>
                                    <td>Прізвище</td>
                                    <td>${patient.lastName}</td>
                                </tr>

                                <tr>
                                <tr>
                                    <td>Вік</td>
                                    <td>${patient.age}</td>
                                </tr>
                                <tr>
                                    <td>Стать</td>
                                    <td>${patient.sex}</td>
                                </tr>
                                <tr>
                                    <td>Адреса</td>
                                    <td>${patient.address}</td>
                                </tr>
                                <tr>
                                    <td>Телефон</td>
                                    <td>${patient.phone}</td>
                                </tr>
                                <tr>
                                    <td>Номер АК</td>
                                    <td>${patient.numberAK}</td>
                                </tr>
                                <tr>
                                    <td>Ріст</td>
                                    <td>${patient.height} см</td>
                                </tr>
                                <tr>
                                    <td>Вага</td>
                                    <td>${patient.weight} кг</td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                        <ul style="margin-left: 5%;" class="list-inline">
                            <li>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#examinations">Історія хвороб
                                </button>
                            </li>
                            <li>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#analisesModal">
                                    Назначити аналізи
                                </button>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#analisesModal">
                                    Результати аналізів
                                </button>
                            </li>
                        </ul>
                        <br>
                        <button style="margin-left: 7%" type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#myModal">
                            Назначити лікування
                        </button>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Призначення лікування</h4>
            </div>
            <form method="post">
                <div class="modal-body">
                    Діагноз: <input type="text" style="width: 500px" required name="diagnose">
                    <div class="form-group">
                        <label for="sel1">Ліки:</label>
                        <select name="medicaments" class="form-control" multiple id="sel1">
                            <c:forEach var="medicament" items="${medicaments}">
                                <option>${medicament.title}</option>
                                <</c:forEach>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="Призначити">
                </div>
            </form>
        </div>

    </div>
</div>

<div id="analisesModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Призначення аналізів</h4>
            </div>
            <form action="addAnalises?id=${patient.id}" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="sel1">Ліки:</label>
                        <c:forEach var="analis" items="${analises}">
                            <input type="checkbox" name="analises" value="${analis.id}">${analis.analisesType}
                        </c:forEach>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" value="Сформувати документ">
                </div>
            </form>
        </div>

    </div>
</div>



<div id="examinations" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Обстеження:</h4>
            </div>
            <div class="modal-body">
                <c:forEach var="examination" items="${patient.examinations}">
                    <table class="table table-user-information">
                        <tbody>
                        <tr>
                            <td>Лікар:</td>
                            <td>${examination.user.firstName} ${examination.user.lastName}</td>
                        </tr>
                        <tr>
                            <td>Дата реєстрації:</td>
                            <td>${examination.date}</td>
                        </tr>
                        <tr>
                            <td>Діагноз:</td>
                            <td>${examination.diagnose}</td>
                        </tr>
                        <tr>
                            <td>Ліки:</td>
                            <td>
                                <c:forEach var="medicament" items="${examination.medicaments}">
                                    ${medicament.title}<br>
                                </c:forEach>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </c:forEach>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
</body>
</html>

<%--<p>${patient.firstName} </p>--%>

<%--<c:forEach var="examination" items="${patient.examinations}">--%>
<%--<p>${examination.diagnose}</p>--%>
<%--</c:forEach>--%>
