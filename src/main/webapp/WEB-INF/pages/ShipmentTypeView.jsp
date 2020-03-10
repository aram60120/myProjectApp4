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
<H3>WELCOME TO THE SHIPMENT TYPE VIEW PAGE</H3>
<table border="1">
<tr>
<th>ID</th>   <td>${ob.shipId }</td>
</tr>
<tr>
<th>MODE</th> <td>${ob.shipMode }</td>
</tr>
<tr>
<th>CODE</th>  <td>${ob.shipCode }</td>
</tr>
<tr>
<th>ENABLE</th>  <td>${ob.enbShip }</td>
</tr>
<tr>
<th>GRAD</th>  <td>${ob.shipGrad }</td>
</tr>
<tr>
<th>NOTE</th>  <td>${ob.shipDesc }</td>
</tr>
</table>
<a href="excel?id=${ob.shipId }"> <img src="../resources/images/excel.png" width="30" height="30"/>excel</a>
<%--  <a href="excel?id=${ob.shipId }">EXCELEXPORT</a> --%>
<a href="pdf?id=${ob.shipId }"> <img src="../resources/images/pdf.png" width="30" height="30"/>pdf</a>
</body>
</html>