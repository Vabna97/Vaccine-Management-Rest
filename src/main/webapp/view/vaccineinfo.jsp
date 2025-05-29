<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaccine Management</title>
<link type=text/css rel="stylesheet" href="./style.css">
<style>
           body {
               background-color: #E6E6FA; /* Mint pink background */
               color: black; /* Black text */
           }
       </style>
</head>
<body>

<div id="wrapper">
    <div id="header">
    	<h1 style="text-align: center">Vaccine Stock Management Application</h1>
   	</div>
</div>
    
<div id="container">
    
    	<div id="content">
    
   <!--  	<!-- <a href="/CRM/showForm">Click here to register</a> -->
    	<input type="button" value="Register Customer" 
    	onClick="window.location.href='/vacmgmt/show-form'; return false;" 
    	class="add-button" /> 
    	    <table border="1">
    	    
    	           <tr>
    	           <th>Vaccine Name</th>
    	           <th>Manufacturing Company</th>
    	           <th>Price</th>
    	           <th>Current Stock</th>
    	           <th>Supplier</th>
    	           <th>Supplier Contact Number</th>
    	           <th>Update Data</th>
    	           <th>Delete Data</th>
    	       
    	           </tr>
    	           <c:forEach var="vaccines"  items="${vaccinedata}">
    	           
    	           <c:url var="UpdateLink" value="/update-vac"> 
    	           
    	           <c:param name="vxid" value="${vaccines.id}"></c:param>
    	           
    	           </c:url>
    	           <c:url var="DeleteLink" value="/delete-data"> 
    	           <c:param name="vxid" value="${vaccines.id}"></c:param>
    	           
    	           </c:url>
    	          
    	           
    	           <tr>
    	              <td>${vaccines.vaccineName}</td>
    	              <td>${vaccines.manufacturingCompany}</td>
    	              <td>${vaccines.price}</td>
    	              <td>${vaccines.currentStock}</td>
    	              <td>${vaccines.supplier}</td>
    	              <td>${vaccines.supplierContactNumber}</td>
    	              
    	           <td><a href="${UpdateLink}">Update Information</a> </td>
    	           <td><a href="${DeleteLink}">Delete Information</a> </td>
    	              
    	           </tr>
    	           
    	           </c:forEach>
    	    
    	    </table>
    	
    	
    	</div>
    
    </div>
</body>
</html>