<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
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
<div class="card-header">
<H3>WELCOME TO THE SHIPMENT TYPE VIEW PAGE</H3>
</div>
<div style="background-color: yellow;">
<table class="table table-hover">
<tr>
<th>UMID</th>   <td>${ob.uomId }</td>
</tr>
<tr>
<th>UMTYPE</th> <td>${ob.uomType }</td>
</tr>
<tr>
<th>UOMMODEL</th>  <td>${ob.uomModel }</td>
</tr>
<tr>
<th >NOTE</th>  <td>${ob.description }</td>
</tr>
</table>
<a href="excel?id=${ob.uomId}">ExcelExport</a>
<a href="pdf?id=${ob.uomId}">PDF Export</a>
</div>
<div class="class-footer  bg-info text-white text-center">
<b>${message}</b>

</div>

</div>  <!-- card end -->
</div>   <!-- container end -->

</body>
</html>