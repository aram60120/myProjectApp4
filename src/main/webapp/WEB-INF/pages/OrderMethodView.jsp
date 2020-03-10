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
<div class="card-header  bg-primary text-white text-center">
<H3>WELCOME TO THE SHIPMENT TYPE VIEW PAGE</H3>
</div>

<div style="background-color:orange; ">
<table class="table table-hover">
<tr>
<th>ORDERID</th>   <td>${ob.orderId }</td>
</tr>
<tr>
<th>ORDERMODE</th> <td>${ob.orderMode }</td>
</tr>
<tr>
<th>ORDERCODE</th>  <td>${ob.orderCode }</td>
</tr>
<tr>
<th>ORDERTYPE</th><td>${ob.orderType}</td>
<th>ORDERACCEPT</th><td>${ob.orderAccept}</td>
</tr>
<tr>
<th >NOTE</th>  <td>${ob.description }</td>
</tr>
</table>
</div>

<div style="background-color:black">
<td>
<a href="excel?id=${ob.orderId}">Excel export</a>
</td>
<td style="color:red;">
<a href="pdf?id=${ob.orderId}">Pdf Export</a>
</td>
</div>
<div class="class-footer  bg-info text-white text-center">
<b>${message}</b>

</div>

</div>  <!-- card end -->
</div>   <!-- container end -->

</body>
</html>