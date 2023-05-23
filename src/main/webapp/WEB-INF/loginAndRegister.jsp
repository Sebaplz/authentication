<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Register Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5 d-flex justify-content-around">
    <div>
        <h1>Register</h1>
        <form:form action="/registration" method="post" modelAttribute="register" class="mt-5">
            <div class="d-flex justify-content-between mt-3">
                <form:label path="userName" class="fs-5">User Name:</form:label>
                <form:input path="userName"/>
            </div>
            <form:errors path="userName" class="text-danger"/>
            <div class="d-flex justify-content-between mt-3">
                <form:label path="email" class="fs-5">Email:</form:label>
                <form:input path="email" type="email"/>
            </div>
            <form:errors path="email" class="text-danger"/>
            <div class="d-flex justify-content-between mt-3">
                <form:label path="password" class="fs-5">Password:</form:label>
                <form:password path="password" />
            </div>
            <form:errors path="password" class="text-danger"/>
            <div class="d-flex justify-content-between mt-3">
                <form:label path="passwordConfirmation" class="fs-5">Password Confirmation:</form:label>
                <form:password path="passwordConfirmation" />
            </div>
            <form:errors path="passwordConfirmation" class="text-danger"/>
            <div class="d-flex justify-content-end mt-3">
                <input type="submit" value="Register!" class="btn btn-success"/>
            </div>
        </form:form>
    </div>
    <div class="ms-5">
        <h2 class="fs-1">Login</h2>
        <form:form action="/login" method="post" modelAttribute="login" class="mt-5">
            <div class="d-flex justify-content-between mt-3">
                <form:label path="email" class="fs-5">Email:</form:label>
                <form:input path="email" type="email"/>
            </div>
            <form:errors path="email" class="text-danger"/>
            <div class="d-flex justify-content-between mt-3">
                <form:label path="password" class="fs-5">Password:</form:label>
                <form:password path="password" />
            </div>
            <form:errors path="password" class="text-danger"/>
            <p class="text-danger">${error}</p>
            <div class="d-flex justify-content-end mt-3">
                <input type="submit" value="Login!" class="btn btn-success"/>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>