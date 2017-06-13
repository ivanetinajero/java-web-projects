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
	            <li><a href="${pageContext.request.contextPath}/view/admin/movie?action=view" data-icon="video" class="ui-btn-active">Movies</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/user?action=view" data-icon="user" >Users</a></li>	            	            
	            <li><a href="${pageContext.request.contextPath}/logout" data-icon="power">Logout</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
						
		<form data-ajax="false" method="post" name="form" action="${pageContext.request.contextPath}/view/admin/movie?action=save" enctype="multipart/form-data">
			
			<fieldset data-role="fieldcontain"> 
				<label for="title">Title:</label> 
				<input type="text" name="title" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain">  
				<label for="cast">Cast:</label>
				<input type="text" name="cast" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain">
				<label for="director">Director:</label> 
				<input type="text" name="director" required="required"/>
			</fieldset>	
			
			<fieldset data-role="fieldcontain">
				<label for="year">Year:</label>
				<input type="text" name="year" required="required"/>
			</fieldset>	

			<fieldset data-role="fieldcontain">
				<label for="duration">Duration:</label>
				<input type="text" name="duration" required="required"/>
			</fieldset>	

			<fieldset data-role="fieldcontain"> 
				<label for="genre">Genre:</label>
				<input type="text" name="genre" required="required"/>
			</fieldset>
			
			<fieldset data-role="fieldcontain"> 
				<label for="synopsis">Synopsis:</label>
				<input type="text" name="synopsis" required="required"/>
			</fieldset>		
			
			<fieldset data-role="fieldcontain"> 
				<label for="image">Image:</label>
				<input type="file" name="image" />
			</fieldset>	
				
			<input type="submit" value="Upload" />
		</form>	
			
	</div><!-- /content -->		
		 
</div><!-- /page -->

</body>
</html>