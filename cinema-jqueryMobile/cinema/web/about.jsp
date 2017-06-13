<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>About Page</title> 
	
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
	            <li><a href="${pageContext.request.contextPath}/view/admin/index.jsp" data-icon="user">Login</a></li>            
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">		
      <div>        
         <center>
            <h4>About Cinema Plus</h4>            
            <img src="${pageContext.request.contextPath}/images/about.png">
         </center>
         <p>
            If you purchase our Udemy course <a href='#'>Developing Mobile Web Applications with jQuerymobile,
               Servlets and JSPs</a> you will be able to develop this entire application step by step from scratch.<br><br>                        
               All the source code and documentation will be available for you. If you have any questions, let me know!<br>
               Happy coding!!
         </p>         
		</div>
	</div><!-- /content -->		
		 
	<div data-role="footer" data-position="fixed" data-theme="b">
		<div data-role="navbar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/about.jsp" data-icon="info" class="ui-btn-active">About</a></li>            
            <li><a href="${pageContext.request.contextPath}/contact.jsp" data-icon="mail">Contact</a></li>
        </ul>
    </div><!-- /navbar -->
	</div><!-- /footer -->
</div><!-- /page -->

</body>
</html>