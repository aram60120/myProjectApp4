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
<form:form action="update" method="POST" modelAttribute="orderMethodType">
<div class="row">
<div class="col-4">
<label for="orderId">ORDER ID</label>
</div>
<div class="col-4">
<form:input  path="orderId"  readonly="true" class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="orderMode">ORDER MODE</label>
</div>
<div class="col-4">
<form:radiobutton    path="orderMode"  value="Sale"/>Sale
<form:radiobutton path="orderMode" value="Purchase"/>Purchase 
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="orderCode">ORDER CODE</label>
</div>
<div class="col-4">
<form:input        path="orderCode" class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div> 
<div class="row">
<div classs="col-4">
<label for="orderType">ORDER TYPE</label>
</div>
<div class="col-4">
<form:select path="orderType">
<form:option value="--SELECT--">SELECT</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FCFO">FCFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>
</div>
<div class="col-4">
<!-- ERRROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="orderAccept">ORDERACCEPT</label>
</div>
<div class="col-4">
<form:checkbox path="orderAccept" value="multi-model"/>MULTI-MODEL
<form:checkbox path="orderAccept" value="Accept-return"/>ACCEPT-RETURN
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="description">DESCRIPTION</label>
</div>
<div class="col-4">
<form:textarea   path="description" class="form-control"/>
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

<!-- <a href="register"    class="btn btn-primary text-whit" >Previous</a> -->
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