<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custome Login</title>
</head>

<body>
<h1>My Custom Login page</h1>
<c:if test="${param.error!=null }">
<i>Error occured while logging in</i>
<br/>
</c:if>
<form:form action = "process-login" method="Post">

Username: <input type="text" name="username"/>
<br/>

Password :<input type = "password" name="password"/>
<br/>

<input type = "submit" value = "login"/>
</form:form>
</body>
</html>