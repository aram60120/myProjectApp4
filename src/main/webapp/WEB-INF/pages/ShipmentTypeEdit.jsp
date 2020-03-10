<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-white text-center">
<h3>WELCOME TO SHIPMENT TYPE EDIT PAGE</h3>
</div>
<div class="card-body">
<form:form action="update" method="POST" modelAttribute="shipmentType">
<div class="row">
<div class="col-4">
<label for="shipId">SHIPMENTID</label>
</div>
<div class="col-4">
<form:input  path="shipId"  readonly="true" class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="shipMode">SHIPMENT MODE</label>
</div>
<div class="col-4">
<form:select   path="shipMode"  class="form-control">
<form:option value="">--select--</form:option>
<form:option value="Air">Air</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="Ship">Ship</form:option>
<form:option value="Train">Train</form:option>
</form:select>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="shipCode">Ship Code</label>
</div>
<div class="col-4">
<form:input        path="shipCode" class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div> 
<div class="row">
<div classs="col-4">
<label for="enbShip">ENABLE SHIPMENT</label>
</div>
<div class="col-4">
<form:select path="enbShip">
<form:option value="--select--">select</form:option>
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>
</form:select>
</div>
<div class="col-4">
<!-- ERRROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="shipGrad">SHIPMENT GRADE</label>
</div>
<div class="col-4">
<form:radiobutton path="shipGrad" value="A"/>A
<form:radiobutton path="shipGrad" value="B"/>B
<form:radiobutton path="shipGrad" value="C"/>C
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="shipDesc">DESCRIPTION</label>
</div>
<div class="col-4">
<form:textarea   path="shipDesc" class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
</div>
<div class="col-4">
<input type="submit" value="Update" class=" btn btn-danger" text-uppercase/>

<a href="register"    class="btn btn-primary text-whit" >Previous</a>
<a href="all"    class="btn btn-danger">Previous</a>
</div>
</div>
</form:form>
</div>
<c:if test="${!empty message }">
                                                                         <div class="card-footer  bg-info text-white text-center">
                                                                          <b>${message} </b>
                                                                          </div>
                                  </c:if> 
</div><!-- card end -->
</div> <!-- container -->
</body>
</html>