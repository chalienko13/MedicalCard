<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Авторизация</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>
<div id="login-form">
	<h1>Авторизація</h1>

	<fieldset>
		<form action="/login" href="/login" method="post">
			<input type="text" required value="Логин" name="username">
			<input type="password" required value="Пароль" name="password">
			<input type="submit" value="УВІЙТИ">
		</form>
	</fieldset>

</div>
</body>
</html>