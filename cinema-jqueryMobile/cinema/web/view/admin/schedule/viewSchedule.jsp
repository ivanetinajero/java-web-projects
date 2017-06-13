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
	            <li><a href="${pageContext.request.contextPath}/view/admin/movie?action=view" data-icon="video" class="ui-btn-active">Movies</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/user?action=view" data-icon="user" >User</a></li>	            	            
	            <li><a href="${pageContext.request.contextPath}/logout" data-icon="power">Logout</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">
		
		<ul data-role="listview" data-inset="true">			
				<li>
			        <img src="${pageContext.request.contextPath}/images/movies/${movie.image}">
			    	<h2>${movie.title}</h2>
			    	<p><b>Genre</b>: ${movie.genre} | Duration: ${movie.duration} min. | Year: ${movie.year}
			    	 | Director: ${movie.director}
			    	</p>
			    </li>			   			
		</ul>

	
		     <fieldset data-role="collapsible">
		        <legend>Add Schedule</legend>   		    		
			<form method="post" name="form" data-ajax="false" action="${pageContext.request.contextPath}/view/admin/schedule" >
				
				<fieldset data-role="fieldcontain"> 
					<label for="title">Screen:</label> 
					 <select name="screen" id="screen">
				        <option value="Screen 1">Screen 1</option>
				        <option value="Screen 2">Screen 2</option>
				        <option value="Screen 3">Screen 3</option>
				        <option value="Screen 4">Screen 4</option>
				        <option value="Screen 5">Screen 5</option>
				        <option value="Premium">Premium</option>
				     </select>
				</fieldset>
				
				<fieldset data-role="fieldcontain">  
					<label for="date">Date (yyyy-mm-dd):</label>
					<input type="text" name="date" required="required"/>
				</fieldset>
				
				<fieldset data-role="fieldcontain">
					<label for="time">Time (h:m):</label> 
					<input type="text" name="time" required="required"/>
				</fieldset>	
			
				<fieldset data-role="fieldcontain">
					<label for="cost">Cost:</label> 
					<input type="text" name="cost" required="required"/>
				</fieldset>
				<input type="hidden" name="idMovie" value="${movie.id}"/>	
				<input type="submit" value="Save" />
			</form>
			</fieldset>
		<h5><font color='red'>${message}</font></h5>
		
		<table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
	     <thead>
	       <tr>
	         <th data-priority="1">Date</th>
	         <th data-priority="2">Time</th>
	         <th data-priority="3">Screen</th>
	         <th data-priority="4">Cost</th>
	         <th data-priority="5">Delete</th>         
	       </tr>
	     </thead>
	     <tbody>     
	     	<c:forEach items="${schedule}" var="schedule" varStatus="status">
			    <tr>
		         <td>${schedule.date}</td>
		         <td>${schedule.time}</td>
		         <td>${schedule.screen}</td>
		         <td>${schedule.cost}</td>	         
		         <td><a href="${pageContext.request.contextPath}/view/admin/schedule?action=delete&idSchedule=${schedule.id}&idMovie=${movie.id}">
		         <img src="${pageContext.request.contextPath}/images/delete.png" title="Delete this schedule"></a></td>        
		       </tr>						    
	        </c:forEach>     
	       </tbody>
	   </table>
	</div><!-- /content -->		

</div><!-- /page -->

</body>
</html>