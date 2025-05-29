<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration form</title>
<link type=text/css rel="stylesheet" href="./style.css">
<link type=text/css rel="stylesheet" href="./add-vaccine-style.css">

</head>
<body>
    <div id="wrapper">
    	<div id="header">
    			<h1>Add Vaccine Form</h1>
    	</div>
    </div>
    
    <form:form action="add-vac" modelAttribute="vaccine">
      <table>
          <form:hidden path="id"/>
          <tr>
          <th>Vaccine Name</th>
          <td><form:input path="vaccineName" /></td>
          </tr>
              <tr>
          <th>Manufacturing Company</th>
          <td><form:input path="manufacturingCompany" /></td>
          </tr>
              <tr>
          <th>Price</th>
          <td><form:input path="price" /></td>
          </tr>
          <th>Current Stock</th>
          <td><form:input path="currentStock" /></td>
          </tr>
              <tr>
          <th>Supplier</th>
          <td><form:input path="supplier" /></td>
          </tr>
              <tr>
          <th>Supplier Contact Number</th>
          <td><form:input path="supplierContactNumber" /></td>
          </tr>
          
                <tr>
          
          <td><input type="submit" value="Register"/></td>
          </tr>
      </table>
  </form:form>
</body>
</html>