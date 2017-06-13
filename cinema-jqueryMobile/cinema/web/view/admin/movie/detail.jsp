<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Cinema Home</title> 
	
	<jsp:include page="/includes/head.html" />
   
</head> 
<body> 

<div data-role="page">

	<div data-role="header" style="overflow:hidden;" data-theme="b" data-position="fixed">
	<h1>${initParam['siteName']}</h1>	
	<!-- http://demos.jquerymobile.com/1.4.5/panel-swipe-open/ -->	
	    <div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/view/admin/movie?action=view" data-icon="video" class="ui-btn-active">Movies</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/user?action=view" data-icon="user" >Users</a></li>	            	            
	            <li><a href="${pageContext.request.contextPath}/logout" data-icon="power">Logout</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
			 
		<h5><font color='red'>${message}</font></h5>
		
		<ul data-role="listview" data-inset="true">			
				<li><a href="#">
			        <img src="${pageContext.request.contextPath}/images/movies/${movie.image}">
			    	<h2>${movie.title}</h2>
			    	<p><b>Genre</b>: ${movie.genre} | ${movie.duration} min.</p></a>
			    </li>			   			
		</ul>
		
		<div data-role="collapsible">
		    <h4>Details</h4>
		    <p><b>Status:</b> ${movie.status}</p>
		    <p><b>Year:</b> ${movie.year} </p>
		    <p><b>Director:</b> ${movie.director} </p>
		    <p><b>Cast:</b> ${movie.cast}</p>		    
		    <p><b>Synopsis: </b>${movie.synopsis}</p>
		</div>			
		
	</div><!-- /content -->		
		 
	<div data-role="footer" data-position="fixed" data-theme="b">
		<div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/about.jsp" data-icon="info">About</a></li>            
	            <li><a href="${pageContext.request.contextPath}/contact.jsp" data-icon="mail">Contact</a></li>
	        </ul>
	   	 </div><!-- /navbar -->
	</div><!-- /footer -->
	
</div><!-- /page -->

</body>
</html>