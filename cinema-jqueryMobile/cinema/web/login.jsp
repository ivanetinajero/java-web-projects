<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Login</title> 
	
	<jsp:include page="/includes/head.html" />

</head> 
<body> 

<div data-role="page">

	<div data-role="header" style="overflow:hidden;" data-theme="b" data-position="fixed">
	<h1>${initParam['siteName']}</h1>	
	    <div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}" data-icon="home">Home</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=playing" data-icon="video">Playing now</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=coming" data-icon="calendar">Coming soon</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/index.jsp" data-icon="user" class="ui-btn-active">Login</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
		
		<div>
         <center>
			<h4>Welcome to Administration Section</h4>
			<img src="${pageContext.request.contextPath}/images/lock.png">
         </center>
		</div>
		
		<form action="j_security_check" method="post">
			 <label for="username">Username</label>
		     <input data-clear-btn="false" name="j_username" id="j_username" value="" type="text">
		     <label for="password-1">Password</label>
		     <input data-clear-btn="false" name="j_password" id="j_password" value="" type="password">
		     <input value="Login" type="submit">		     
		</form>
		
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