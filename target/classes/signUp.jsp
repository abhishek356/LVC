<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
</head>
<body>
<form:form action="process-signUp" method = "Post" modelAttribute="SignUpDTO">
<form:label path ="username">
Enter UserName:
</form:label>
<form:input type="text" path ="username"></form:input>
<br>
<form:label path="password">
Enter Password:
</form:label>

<form:input type ="password" path="password"></form:input>
<br>

<input type ="submit" value = "sign Up">
</form:form>
</body>
</html>