<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Contact Page</title> 
	
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
		<h3>Send us your comments</h3>
      <h5><font color='red'>${message}</font></h5>
      <form data-ajax="false" method="post" name="form" action="${pageContext.request.contextPath}/contact" >
			
			<fieldset data-role="fieldcontain"> 
				<label for="name">Name:</label> 
				<input type="text" name="name" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain">  
				<label for="email">Email:</label>
				<input type="text" name="email" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain">
				<label for="comments">Comments:</label> 
				<textarea name="comments" id="comments" required="required"></textarea>
			</fieldset>	
						
			<input type="submit" value="Send" />
		</form>	
	</div><!-- /content -->		
		 
	<div data-role="footer" data-position="fixed" data-theme="b">
		<div data-role="navbar">
        <ul>
            <li><a href="${pageContext.request.contextPath}/about.jsp" data-icon="info">About</a></li>            
            <li><a href="${pageContext.request.contextPath}/contact.jsp" data-icon="mail" class="ui-btn-active">Contact</a></li>
        </ul>
    </div><!-- /navbar -->
	</div><!-- /footer -->
</div><!-- /page -->

</body>
</html>