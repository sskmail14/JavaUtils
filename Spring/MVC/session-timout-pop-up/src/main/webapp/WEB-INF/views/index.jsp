<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form:form method="post" action="login" commandName="loginForm">
    <form:input type="text" path="userName" name="userName" id="un" required="true"/>
    <form:input type="password" path="password" name="password" id="pwd"  required="true" />
    <input type="submit" value="LetMe In" />
</form:form>