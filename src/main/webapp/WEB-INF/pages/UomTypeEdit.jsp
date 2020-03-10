<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image: ">
<%@include file="UserMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-white text-center">
<h3>WELCOME TO UOMTYPE EDIT PAGE</h3>
</div>
<div class="card-body">
<form:form action="update" method="POST" modelAttribute="uomType">
<div class="row">
<div class="col-4">
<label for="uomId">UOMTYPEID</label>
</div>
<div class="col-4">
<form:input  path="uomId"  readonly="true" class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="uomType">UOMTYPE</label>
</div>
<div class="col-4">
<form:select   path="uomType"  class="form-control">
<form:option value="">--select--</form:option>
<form:option value="Parking">PARKING</form:option>
<form:option value="Noparking">NOPARKING</form:option>
<form:option value="NA">NA</form:option>
</form:select>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="uomModel">UOMMODEL</label>
</div>
<div class="col-4">
<form:input        path="uomModel" class="form-control"/>
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