<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process Form</title>
</head>
<body>
<h1>Form Processing</h1>
<p>UserName : ${user.userName}</p>
<p>CrushName : ${user.crushName}</p>
<p>Country : ${user.country}</p>
<p>Gender : ${user.gender}</p>

<br>
<form:form action="logout" method="POST">
<input type = "submit" value = "logout">
</form:form>
</body>
</html>