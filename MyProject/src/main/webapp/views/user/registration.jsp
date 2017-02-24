<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript">
 	
	function doAjax(){
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
	}
</script> 



	<form:form modelAttribute="user" action="registration" method="post" onkeyup="doAjax()">
		<div id="form-main">
			<div id="form-div">
				<form class="form" id="form1">

					<p class="name">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="name">${usernameException}</label>
						</div>
						<form:input path="name" type="text"
							class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
							placeholder="Name" id="name"/>
							<span id="checkname" style="color:black;"></span>
					</p>

					<p class="email">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="email">${emailException}</label>
						</div>
						<form:input path="email" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>

					<p class="password">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="password">${passwordException}</label>
						</div>
						<form:input path="password" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="password" placeholder="password" />
					</p>

					<p class="phone">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="phone">${phoneException}</label>
						</div>
						<form:input path="phone" type="text"
							class="validate[required,custom[password]] feedback-input"
							id="phone" placeholder="phone" />
					</p>

					<div class="submit">
						<input type="submit" value="SEND" id="button-blue" />
						<div class="ease"></div>
					</div>
					
				</form>
			</div>
	</form:form>
