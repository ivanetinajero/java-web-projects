<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html> 
<html> 
<head> 
	<title>List of Users</title> 
	
	<jsp:include page="/includes/head.html" />

</head> 
<body> 

<div data-role="page">

	<div data-role="header" style="overflow:hidden;" data-theme="b" data-position="fixed">
	<h1>${initParam['siteName']}</h1>		
	    <div data-role="navbar">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/view/admin/movie?action=view" data-icon="video">Movies</a></li>
	            <li><a href="${pageContext.request.contextPath}/view/admin/user?action=view" data-icon="user" class="ui-btn-active" >Users</a></li>	            	            
	            <li><a href="${pageContext.request.contextPath}/logout" data-icon="power">Logout</a></li>	            	           
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /header -->

	<div data-role="content">

	<a href="${pageContext.request.contextPath}/view/admin/user?action=add" class="ui-btn ui-btn-inline ui-icon-plus ui-btn-icon-left">Add User</a>

	<h5><font color='red'>${message}</font></h5>	
	<table data-role="table" id="table-column-toggle" data-mode="columntoggle" class="ui-responsive table-stroke">
     <thead>
       <tr>
         <th data-priority="6">Id</th>
         <th data-priority="1">Name</th>
         <th data-priority="2">Username</th>         
         <th data-priority="3"><center>Delete</center></th>         
       </tr>
     </thead>
     <tbody>     
     	<c:forEach items="${users}" var="user" varStatus="status">
		    <tr>
	         <td>${user.id}</td>
	         <td>${user.name}</td>
	         <td>${user.username}</td>	         
	         <td><center><a href="${pageContext.request.contextPath}/view/admin/user?action=delete&id=${user.id}">
	         <img src="${pageContext.request.contextPath}/images/delete.png" title="Delete this user"></a></center></td>	        
	       </tr>						    
        </c:forEach>     
       </tbody>
   </table>
		
	</div><!-- /content -->		
		 	
</div><!-- /page -->

</body>
</html>