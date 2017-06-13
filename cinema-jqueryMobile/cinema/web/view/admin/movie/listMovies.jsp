<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>List of Movies</title> 
	
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

	<a href="${pageContext.request.contextPath}/view/admin/movie?action=add" class="ui-btn ui-btn-inline ui-icon-plus ui-btn-icon-left">Add Movie</a>

	<h5><font color='red'>${message}</font></h5>	
	<table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
     <thead>
       <tr>
         <th data-priority="6">Id</th>
         <th data-priority="1">Movie Title</th>
         <th data-priority="2">Year</th>
         <th data-priority="4">Genre</th>
         <th data-priority="5">Duration</th>
         <th data-priority="8">Status</th>
         <th data-priority="7">Active</th>
         <th data-priority="3">Delete</th>
         <th data-priority="3">Schedule</th>
       </tr>
     </thead>
     <tbody>     
     	<c:forEach items="${movies}" var="movie" varStatus="status">
		    <tr>
	         <td>${movie.id}</td>
	         <td>${movie.title}</td>
	         <td>${movie.year}</td>
	         <td>${movie.genre}</td>
	         <td>${movie.duration} min.</td>
	         <td>${movie.status}</td>
            <td>
               <c:if test="${movie.status=='coming'}">
                  <center><a href="${pageContext.request.contextPath}/view/admin/movie?action=active&id=${movie.id}">
                  <img src="${pageContext.request.contextPath}/images/check.png" title="Active this movie"></a>
                  </center>
               </c:if>
            </td>
	         <td><center><a href="${pageContext.request.contextPath}/view/admin/movie?action=delete&id=${movie.id}">
	         <img src="${pageContext.request.contextPath}/images/delete.png" title="Delete this movie"></a></center></td>
	         <td><center><a href="${pageContext.request.contextPath}/view/admin/schedule?action=view&id=${movie.id}">
	         <img src="${pageContext.request.contextPath}/images/calendar.png" title="View the schedule for this movie"></a></td></a></center></td>
	       </tr>						    
        </c:forEach>     
       </tbody>
   </table>
		
	</div><!-- /content -->		
		 	
</div><!-- /page -->

</body>
</html>