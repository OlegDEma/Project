
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


 <link rel="stylesheet" href="css/author.css">




	<c:forEach var="provider" items="${providers}">
		${provider.name}
		<a href="deleteProviders/${provider.id}">delete provider</a>

		<br>
	</c:forEach>


<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new Vud</h2>

  <form:form modelAttribute="provider" action="saveProviders" method="post" class="login-container">
  <p><form:input path="name"  type="text" placeholder="name"/></p> 
  <p><form:input path="address"  type="text" placeholder="address"/></p> 
  <p><form:input path="phone"  type="text" placeholder="phone"/></p> 
    <p><input type="submit" value="save vud"></p>
  </form:form>
</div>

<br>
<a href="home" >home</a>

