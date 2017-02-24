
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


 <link rel="stylesheet" href="css/author.css">
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
 	
	/* function doAjax(){
		$.ajax({
			url:'checkName',
			data:({name : $('#name').val()}),
			success:function(data){
				if(data == "error"){
					$('#checkname').html(data);
					 $('#checkname').css('color','red');
				}else{
					$('#checkname').html(data);
				}
			}
		});		
	} */
	$('#submit').click(function () {
		alert("EZ");

	    /* var hotel = {
	    		hotelName: document.getElementById('hotelName').value,

	        stars: document.getElementById('stars').value,

	        type_of_food:  document.getElementById('food').value,
	        
	        city: {
	            id: document.getElementById('idCity').value
	        }
	         
	    };
	    document.getElementById('hotelName').value = '';
	    document.getElementById('stars').value = 'stars';
	    document.getElementById('food').value = 'type of food';
	    $.ajax({
	        url: 'saveHotel?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
	        contentType: 'application/json; charset=UTF-8',
	        dataTypes: 'json',
	        method: "POST",
	        data: JSON.stringify(hotel),
	        success : function () {
	            load();
	        }

	    }); */
	});
</script> 
 




<%-- 	<c:forEach var="delivery" items="${deliverys}">
		${delivery.date}
		<a href="deleteDelivery/${delivery.id}">delete provider</a>

		<br>
	</c:forEach> --%>


<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">new delivery</h2>

  <form:form class="login-container">
  <p><form:input path="date"  type="date" placeholder="date"/></p> 
  <p><form:input path="number"  type="text" placeholder="address"/></p> 
<%--   <p><form:input path="price"  type="text" placeholder="phone"/></p>  --%>
    <p><input id="submit" type="submit" value="save vud"></p>
  </form:form>
</div>

<br>
<a href="home" >home</a>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />


