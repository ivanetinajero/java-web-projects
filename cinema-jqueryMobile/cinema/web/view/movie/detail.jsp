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
	            <li><a href="${pageContext.request.contextPath}" data-icon="home">Home</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=playing" data-icon="video" class="ui-btn-active">Playing now</a></li>
	            <li><a href="${pageContext.request.contextPath}/schedule?action=coming" data-icon="calendar">Coming soon</a></li>
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
		
		<table data-role="table" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive" data-column-btn-theme="b" data-column-btn-text="Columns to display..." data-column-popup-theme="a">
         <thead>
           <tr class="ui-bar-d">
             <th data-priority="1">Time</th>
             <th data-priority="2">Screen</th>
             <th data-priority="3">Cost</th>
           </tr>
         </thead>
         <tbody>
         	<c:forEach items="${schedule}" var="schedule" varStatus="status">
	           <tr>             
	             <td>${schedule.time}</td>
	             <td>${schedule.screen}</td>
	             <td>$${schedule.cost}</td>
	           </tr> 	               			 
			</c:forEach>         
         </tbody>
       </table>
		
	</div><!-- /content -->		
		 
	<div data-role="footer" data-position="fixed" data-theme="b">
		<div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/about.jsp" data-icon="info">About</a></li>            
	            <li><a href="${pageContext.request.contextPath}/contact.jsp" data-icon="mail">Contact</a></li>
	        </ul>
	   	 </div><!-- /navbar -->
	</div><!-- /footer -->
	
	<div data-role="panel" id="left-panel" data-theme="b">
        <p>Administrator</p>
        <a href="#" data-rel="close" class="ui-btn ui-corner-all ui-shadow ui-mini ui-btn-inline ui-icon-delete ui-btn-icon-left ui-btn-right">Close</a>   		
		<form>		    		        
		        <label for="txtuser">Login:</label>		        
		        <input name="txtuser" id="txtuser" placeholder="Text input" value="" type="text">
		        <label for="txtpass">Password:</label>
     			<input data-clear-btn="true" name="txtpass" id="txtpass" value="" autocomplete="off" type="password">
		        <label for="submit-5">Send:</label>
    			<button type="submit" id="submit-5" class="ui-shadow ui-btn ui-corner-all ui-mini">Login</button>		        		        		   
		</form>
	
    </div><!-- /panel -->
	
</div><!-- /page -->

</body>
</html>