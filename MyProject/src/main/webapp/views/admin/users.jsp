<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
 
	function setuser(e){
		$.ajax({
			url:'setUser',
			data:({id : e})			
		});		
		
	};
	function setAdmin(e){
		$.ajax({
			url:'setAdmin',
			data:({id : e})			
		});		
		
	};
	
	function ban(e){
		$.ajax({
			url:'ban',
			data:({id : e})			
		});		
		
	};
	
	function unban(e){
		$.ajax({
			url:'unban',
			data:({id : e})			
		});		
		
	};

 
 	
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
	/* $('#setuser').click(function () {
		alert("EZ");
 */
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
/* 	}); */
</script> 
<body>
<c:forEach var="user" items="${users}">
		${user.name}  ${user.email}  ${user.phone}		
		<a href="deleteUser/${user.id}">delete user</a> 
		<button onclick="setuser('${user.id}')" >set user</button>
		<button onclick="setAdmin('${user.id}')" >set admin</button> 
		<button onclick="ban('${user.id}')" >ban</button> 
		<button onclick="unban('${user.id}')" >unban</button> 
		 

		<br>
	</c:forEach>
	

</body>
</html>