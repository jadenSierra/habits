<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/loginRegister.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="registerContainer">
			<div class="register">
   			<h1>Register</h1>
	   			<form:form action="/register" medoth="post" modelAttribute="newUser">
	   				<div class="form-group">
	   					<form:errors path="firstName"></form:errors>
	   					<form:label path="firstName">First Name:</form:label>
	   					<form:input path="firstName" type="text" class="form-control"></form:input>
	   				</div>
	   				<div class="form-group">
	   					<form:errors path="lastName"></form:errors>
	   					<form:label path="lastName">Last Name:</form:label>
	   					<form:input path="lastName" type="text" class="form-control"></form:input>
	   				</div>
	   				<div class="form-group">
	   					<form:errors path="email"></form:errors>
	   					<form:label path="email">Email:</form:label>
	   					<form:input path="email" type="text" class="form-control"></form:input>
	   				</div>
	   				<div class="form-group">
	   					<form:errors path="password"></form:errors>
	   					<form:label path="password">Password:</form:label>
	   					<form:input path="password" type="password" class="form-control"></form:input>
	   				</div>
	   				<div class="form-group">
	   					<form:errors path="confirm"></form:errors>
	   					<form:label path="confirm">Confirm PW:</form:label>
	   					<form:input path="confirm" type="password" class="form-control"></form:input>
	   				</div>
	   				<input type="submit" value="Submit" class="btn btn-success">
	   			</form:form>
   			</div>
			<div id="heroImgRegister">
			</div>
		</div>
	</div>
</body>
</html>