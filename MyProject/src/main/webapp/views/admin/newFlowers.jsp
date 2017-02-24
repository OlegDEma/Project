
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


 <link rel="stylesheet" href="css/author.css">
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
 	

</script> 




	<c:forEach var="flower" items="${flowers}">
		${flower.name} ${flower.height}
		<img src="${flower.pImage }" alt="add" width="500px" height="500px">
		<a href="deleteFlowers/${flower.id}">delete flower</a>	 
<form:form action="./saveFlowerImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data">
           <input type="text" name="id" value="${flower.id}" >
    <input type="file" name="image">
    <button>save image</button>
</form:form>
		

		<br>
	</c:forEach>


<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new Flower</h2>

<%--   <form:form modelAttribute="flower" action="saveFlowers" method="post" class="login-container">
  <p><form:input path="name"  type="text" placeholder="name"/></p> 
 <p><form:input path="height" type="text" placeholder="height"/></p> 
 <p><form:input path="number"  type="text" placeholder="number"/></p> 
      <p><form:input path="price"  type="text" placeholder=" price"/></p>
       <p><form:input path="widthOfGorshk"  type="text" placeholder=" widthOfGorshk"/></p>
    <p><input type="submit" value="save flower"></p>
  </form:form> --%>
    <form:form modelAttribute="flower" action="saveFlowers" method="post" class="login-container">
  <p><form:input path="name"  type="text" placeholder="name"/> </p> 
 <p><form:input path="height" type="text" placeholder="height"/></p> 
 <p><form:input path="number"  type="text" placeholder="number"/></p> 
     <%--  <p><form:input path="price"  type="text" placeholder=" price"/></p> --%>
       <p><form:input path="widthOfGorshk"  type="text" placeholder=" widthOfGorshk"/></p>
       <form:select path="id" items="${vuds}" itemLabel="type"
			itemValue="id">
		</form:select>
       
    <p><input type="submit" value="save flower"></p>
  </form:form>
 <%--  <form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
           method="post" enctype="multipart/form-data">
    <input type="file" name="image">
    <button>save image</button>
</form:form> --%>
</div>

<br>
<a href="home" >home</a>

