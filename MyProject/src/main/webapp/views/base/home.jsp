<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/lightbox.css" />
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	
	 <script type="text/javascript">
 	
 	function logout(){
		$('#log').click();
	}  

	  $( document ).ready(function() {
 	    var ban = $('#ban').val();
 	    if(ban == '1'){
 	    	$('#log').click();
 	    }
 	});  	
	
	
	function load(e) {

		   

	    $.ajax({
	        url: 'loadFlowers?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
	        contentType: 'application/json; charset=UTF-8',
	        data:({id : e}),
	        dataTypes: 'json',
	        method: "POST",
	        success : function (res) {

	            var allHotels = document.createElement('div');
	            allHotels.id = 'all';

	            var all = '';

	            for(var i = 0; i < res.length; i++){
	            	 var index = res[i].id;
	          
	                all += "<div>"+res[i].name +' '+res[i].price  +'<br>'+'<img style="height:200px; width:200px" src="'+res[i].pImage+'">' + "<a href='deleteHotel/"+index+"'>delete</a></div><br>";
	            }

	           
				$("#main").empty();
				document.getElementById('main').innerHTML = all;
				
	            

	        }

	    })

	}
</script> 
 <body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="index.html"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="index.html">home</a></li>
            <li><a href="about">about us</a></li>
            <li><a href="category">flowers</a></li>
            <li><a href="specials">specials gifts</a></li>
            <sec:authorize access="!isAuthenticated()">
            <li><a href="loginpage">my accout</a></li>	
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
            <li><a href="registration">register</a></li>	
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
            <li><a href="profile">profile</a></li>	
			</sec:authorize>
			
			<!-- <li><button onclick="logout()">logout</button></li>	 -->
			
            <li><a href="price">prices</a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="admin">admin page</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<li><a href="contact">contact</a></li>
		</sec:authorize>
            
            <sec:authorize access="isAuthenticated()">	
            <li><a onclick="logout()">logout</a></li>
            <div style="display: none;">
			 <form:form type="hidden"  action="logout" method="post">
				<button type="hidden" id="log">logout</button>
			</form:form> 
            </div>			
				</sec:authorize>
            </ul>
        </div>     
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
        	
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Featured products   ${user.name} ${user.email} ${user.phone}</div>
        
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="details.html"><img src="images/prod1.gif" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">Product name</div>
                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                    <a href="details.html" class="more">- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
            
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="details.html"><img src="images/prod2.gif" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">Product name</div>
                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                    <a href="details.html" class="more">- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>      
            
            
            
           <div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" title="" /></span>New products</div> 
           
           <div class="new_products">
           
                    <c:forEach var="flower" items="${flowers}">
	 <div class="new_prod_box">
                        <a href="details.html">${flower.name}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="${flower.pImage}" alt="" title="" class="thumb" border="0" style="height: 100px; width: 100px" /></a>
                        <span>${flower.price}</span>
                        <sec:authorize access="isAuthenticated()">	
                       	 	<a href="buy/${flower.id}">Buy</a>           
						</sec:authorize>
                        </div>           
                    </div>		
	</c:forEach>
	
	
            
            </div> 
          
            
        <div class="clear"></div>
        </div>
        
        <div class="right_content">
        	<div class="languages_box">
            <span class="red">Languages:</span>
            <a href="#" class="selected"><img src="images/gb.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="images/fr.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="images/de.gif" alt="" title="" border="0" /></a>
            </div>
                <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#" class="selected">USD</a>
                </div>
                 <div class="clear"></div>
                
               <sec:authorize access="isAuthenticated()">
               <div class="cart">
                  <div class="title"><span class="title_icon"><img src="images/cart.gif" alt="" title="" /></span>My cart</div>
                  <div class="home_cart_content">                  
                  </div>
                  <a href="cart" class="view_cart">view cart</a>
              
              </div>
            
			</sec:authorize> 
              
                       
            	
        
        
             <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title="" /></span>About Our Shop</div> 
             <div class="about">
             <p>
             <img src="images/about.gif" alt="" title="" class="right" />
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
             </p>
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title="" /></span>Promotions</div> 
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>              
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="images/bullet5.gif" alt="" title="" /></span>Categories</div> 
                
                <ul class="list">
                <li><a href="#">accesories</a></li>
                <li><a href="#">flower gifts</a></li>
                <li><a href="#">specials</a></li>
                <li><a href="#">hollidays gifts</a></li>
                <li><a href="#">accesories</a></li>
                <li><a href="#">flower gifts</a></li>
                <li><a href="#">specials</a></li>
                <li><a href="#">hollidays gifts</a></li>
                <li><a href="#">accesories</a></li>
                <li><a href="#">flower gifts</a></li>
                <li><a href="#">specials</a></li>                                              
                </ul>
                
             	<div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>Partners</div> 
                
                <ul class="list">
                <li><a href="#">accesories</a></li>
                <li><a href="#">flower gifts</a></li>
                <li><a href="#">specials</a></li>
                <li><a href="#">hollidays gifts</a></li>
                <li><a href="#">accesories</a></li>
                <li><a href="#">flower gifts</a></li>
                <li><a href="#">specials</a></li>
                <li><a href="#">hollidays gifts</a></li>
                <li><a href="#">accesories</a></li>                              
                </ul>      
             
             </div>         
             
        
        </div>
        
        
       
       
       <div class="clear"></div>
       </div>
       
              
       <div class="footer">
       	<div class="left_footer"><img src="images/footer_logo.gif" alt="" title="" /><br /> <a href="http://csscreme.com/freecsstemplates/" title="free templates"><img src="images/csscreme.gif" alt="free templates" title="free templates" border="0" /></a></div>
        <div class="right_footer">
        <a href="#">home</a>
        <a href="#">about us</a>
        <a href="#">services</a>
        <a href="#">privacy policy</a>
        <a href="#">contact us</a>        
        </div>
        
       
       </div>
    

</div>

</body> 

	<a href="some">some</a>
	
	
	
<sec:authentication property="name" />
<%--
<sec:authorize access="hasRole('ROLE_ADMIN')">

	 <form action="https://www.google.com.ua/" method="get">
<input type="submit" value="GO"></form>
</sec:authorize> --%>

<%-- <sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
</sec:authorize>
<a href="getBooks">Book</a> --%>

<%-- <sec:authorize access="!isAuthenticated()">
	<br>
	<a href="loginpage">login</a>
	<br>
	<a href="registration">registration</a>
	<br>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="profile">profile</a>
</sec:authorize>

	<sec:authorize access="hasRole('ROLE_ADMIN')">	
<a href="users">users</a>
	</sec:authorize>

<br>
<br>
<br>

<a onclick="load('1')">ESC</a>  <a onclick="load('2')">DESC</a>  <a onclick="load('3')">Name</a>

<div id="main">
	 <c:forEach var="flower" items="${flowers}">
	 
			 ${flower.name} ${flower.price}
			<img src='${flower.pImage}' style="height:200px; width:200px">
				
					<a href="buy/${flower.id}">buy</a> 
		<br>
	</c:forEach>
</div>
<button onclick="load()">GOGOOG</button>
<form:form action="buy" method="post">
		<button>buy</button>
	</form:form>
	 --%>
<input type="hidden" id="ban" name="ban"
       value="${ban}" />
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
       <div id="conteiner"></div>
