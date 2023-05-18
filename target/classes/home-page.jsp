<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body align="center">
<form:form action = "process-form" method = "Get" modelAttribute = "userInfo">

<h1 align="center">Love Calculator</h1>
<sec:authorize access="isAuthenticated()">
<form:form action="logout" method="POST">
<input type = "submit" value = "logout">
</form:form>
</sec:authorize>
<hr/>
<h2>Please Register here !</h2> 
<sec:authorize access="hasAuthority('ADMIN')">
<a href="UpdateRoles" >Manage Users</a>
</sec:authorize>
<p>
<label for ="userName">Your Name:</label>
<input type = "text" id="userName" name="userName"/>
</p>

<p>
<label for ="crushName">Crush Name:</label>
<input type = "text" id="crushName" name="crushName"/>
</p>

<p>
<form:label path ="password">Password:</form:label>
<form:password path="password"/>
</p>

<p>
country:<form:select path ="country" items="${countries}"/>

</p>

hobby :
<form:checkbox path="hobby" value="cricket"></form:checkbox>cricket
<form:checkbox path="hobby" value="reading" />reading
<form:checkbox path="hobby" value="travel"/>travel
<form:checkbox path="hobby" value="programming"/> programming

<p>
Gender :
<form:checkbox path="gender" value = "Male"></form:checkbox>Male
<form:checkbox path="gender" value = "Female"></form:checkbox>Female
</p>

<p>
<input type = "submit" value = "calculate"/>
</p>
</form:form>
</body>
</html>