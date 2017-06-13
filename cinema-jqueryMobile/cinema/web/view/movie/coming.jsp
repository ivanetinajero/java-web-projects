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
	    <div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}" data-icon="home">Home</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=playing" data-icon="video">Playing now</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=coming" data-icon="calendar" class="ui-btn-active">Coming soon</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/index.jsp" data-icon="user">Login</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
		
		    <fieldset data-role="collapsible">
		        <legend>Search by date</legend>        
		        <form action="${pageContext.request.contextPath}/schedule?action=search" method="get">
					<div class="ui-field-contain">
				    <fieldset data-role="controlgroup" data-type="horizontal" data-mini="true">
				        <legend>Search by Date:</legend>
				        <select name="txtDate" id="txtDate">
				        	<c:forEach items="${nextDays}" var="day" varStatus="status">
					        	<option value="${day}">${day}</option>						      
					        </c:forEach>
					    </select>				        
    					<button type="submit" id="btnSearch" class="ui-shadow ui-btn ui-corner-all ui-mini">Search</button>
				    </fieldset>
				</div>
				</form>
		    </fieldset>
		
		<h5><font color='red'>${message}</font></h5>
		
		<ul data-role="listview" data-inset="true">
			<c:forEach items="${movies}" var="movie" varStatus="status">
				<li><a href="${pageContext.request.contextPath}/schedule?action=detailMovie&idMovie=${movie.id}">
			        <img src="${pageContext.request.contextPath}/images/movies/${movie.image}">
			    	<h2>${movie.title}</h2>
			    	<p><b>Genre</b>: ${movie.genre} | ${movie.duration} min.</p></a>
			    </li>			   
			</c:forEach>
		</ul>
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