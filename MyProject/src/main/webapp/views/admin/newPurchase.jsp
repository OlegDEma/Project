
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


 <link rel="stylesheet" href="css/author.css">




	<c:forEach var="purchase" items="${purchases}">
		${purchase.pib}
		<a href="deletePurchase/${purchase.id}">delete purchase</a>

		<br>
	</c:forEach>


<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new purchase</h2>

  <form:form modelAttribute="purchase" action="savePurchase" method="post" class="login-container">
  <p><form:input path="address"  type="text" placeholder="address"/></p> 
    <p><form:input path="phone"  type="text" placeholder="phone"/></p> 
      <p><form:input path="pib"  type="text" placeholder="pib"/></p> 
    <p><input type="submit" value="save vud"></p>
  </form:form>
</div>

<br>
<a href="home" >home</a>

