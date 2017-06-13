<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>Add user</title> 
	
	<jsp:include page="/includes/head.html" />

</head> 
<body> 

<div data-role="page">

	<div data-role="header" style="overflow:hidden;" data-theme="b" data-position="fixed">
	<h1>${initParam['siteName']}</h1>	
	    <div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/view/admin/movie?action=view" data-icon="video" >Movies</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/user?action=view" data-icon="user" class="ui-btn-active" >Users</a></li>	            	            
	            <li><a href="${pageContext.request.contextPath}/logout" data-icon="power">Logout</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
						
		<form data-ajax="false" method="post" name="form" action="${pageContext.request.contextPath}/view/admin/user?action=save" >
			
			<fieldset data-role="fieldcontain"> 
				<label for="name">Name:</label> 
				<input type="text" name="name" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain">  
				<label for="username">Username:</label>
				<input type="text" name="username" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain">
				<label for="password">Password:</label> 
				<input type="password" name="password" required="required"/>
			</fieldset>				
				
			<input type="submit" value="Save" />
		</form>	
			
	</div><!-- /content -->		
		 
</div><!-- /page -->

</body>
</html>