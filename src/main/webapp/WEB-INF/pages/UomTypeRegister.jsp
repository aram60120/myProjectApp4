<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<div class="card-header  bg-primary text-center text-white text-uppercase" >
<h3>WELCOME TO UOMTYPE REGESTER PAGE</h3>
</div>
<div class="card-body">
<form:form action="save" method="POST" modelAttribute="uomType">
<div class="row">
<div class="col-4">
<label for=uomType> UOM TYPE</label>
</div>
<div class="col-4">
<form:select path="uomType">
<form:option value="">--SELECT--</form:option>
<form:option value="PARKING"  class="">PARKING</form:option>
<form:option value="NOPACKING">NOPACKING</form:option>
<form:option value="NA">NA</form:option>
</form:select>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label  for="uomModel">UOM MODEL</label>
</div>
<div class="col-4">
<form:input path="uomModel"  class="form-control"/>
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
<label for="description">DICRIPTION</label>
</div>
<div class="col-4">
<form:textarea path="description"  class="form-control" />
</div>
<div class="col-4">
<!-- ERROR MESSAGE -->
</div>
</div>
<div class="row">
<div class="col-4">
</div>
<div class="col-4">
<input type="submit" value="Create Uom" class="btn btn-succes"/>
<input type="reset" value="clear"  class="btn btn-danger"/>
</div>
</div>
</form:form>
</div>
<c:if test="${ !empty message}">
<div class="card-footer bg info text-white text-center ">
<b>${message}</b>
</div>
</c:if>
</div>    <!-- Card End -->

</div>         <!--  Container End  -->
	
	</body>
</html>