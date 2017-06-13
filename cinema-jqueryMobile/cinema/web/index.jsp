<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Cinema Plus</title> 
   
   <jsp:include page="/includes/head.html" />   
   
</head> 
<body> 

<div data-role="page">

	<div data-role="header" style="overflow:hidden;" class="header" data-theme="b" data-position="fixed">
	<h1>${initParam['siteName']}</h1>		
	    <div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}" data-icon="home" class="ui-btn-active">Home</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=playing" data-icon="video">Playing now</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=coming" data-icon="calendar">Coming soon</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/index.jsp" data-icon="user">Login</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
		
		<div>
         <center>
            <h3>Welcome to Cinema Plus</h3>
            <img src="${pageContext.request.contextPath}/images/logo.png">
            <hr>
            <img src="${pageContext.request.contextPath}/images/facebook.png" title="Follow us..">
            <img src="${pageContext.request.contextPath}/images/twitter.png" title="Send us a Twitter..">
            <img src="${pageContext.request.contextPath}/images/instagram.png" title="Pictures..">
         </center>
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