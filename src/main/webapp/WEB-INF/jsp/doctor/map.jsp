<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">♦
        <meta name="author" content="">

        <title>Doctor page</title>

        <!-- Bootstrap core CSS -->
            <link href="<c:url value="../../../resources/css/bootstrap.min.css" />" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<c:url value="../../../resources/css/navbar-fixed-top.css" />" rel="stylesheet">
        <link href="<c:url value="../../../resources/css/doctor.css" />" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="../../../resources/js/bootstrap.min.js"></script>

    <style type="text/css">
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        #map {
            height: 35%;
        }
    </style>
</head>
<body>
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
                <li class="active"><a href="/doctor/map">Карта захворювань</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><p>${user.firstName}  </p></li>
                <li><p>  ${user.lastName}</p></li>
                <li><a href="/"><button href="/" type="button" class="btn btn-default btn-sm">Вихід</button></a> </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div id="map"></div>
<script type="text/javascript">
    var addressArray = [];
    var map;
    function initMap(addressArray) {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            url: '/doctor/mapAll',
            success: function (resultArray) {
                console.log(resultArray);
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 12,
                    center: {lat: 50.4501, lng: 30.5235}
                });
                var geocoder = new google.maps.Geocoder();
                geocodeAddress(geocoder, map,resultArray);
            }
        });


    }
    function geocodeAddress(geocoder, resultsMap,resultArray) {
        console.log(addressArray);
        $.each(resultArray, function (key, val) {
        geocoder.geocode({'address': val.address}, function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                resultsMap.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                    map: resultsMap,
                    title:val.firstName +' ' + val.lastName,
                    position: results[0].geometry.location
                });
                var infowindow = new google.maps.InfoWindow();
                google.maps.event.addListener(marker, 'click', function() {
                    console.log(marker);
                    infowindow.setContent(val.firstName);
                    infowindow.open(map, this);
                });
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    })};




</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDUmw5B2el-wgOgkqV_o0VeKSPkoQn5HFc&callback=initMap">
</script>
</body>
</html>
