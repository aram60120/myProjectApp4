<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body style ="background-color: yellow">
<%@include file= "UserMenu.jsp" %>
<div class="container">
<div class="card">
<div class="card-header bg-primary text-white text-center">
<H3>WELCOME TO UOMTYPE DATA PAGE</H3>
</div>
<div class= "card-body">
<!-- <a href="excel"><img src="../resources/images/excel.png"  width="60" height="60"/>
	excel</a> -->
<a href="excel">excel</a>
<a href="pdf">pdf</a>
<c:choose>
<c:when test="${!empty list }">

 <table border="table table-hover">
<tr class="bg-success text-white">
<th> UMID</th>
<th> UMTYPE</th>
<th> UOMMODEL</th>
<th>NOTE</th>
<th colspan="3">OPERATION</th>
</tr>
<c:forEach  items="${list }"  var="ob">
<tr>
<td>${ob.uomId }</td>
<td>${ob.uomType }</td>
<td>${ob.uomModel }</td>
<td>${ob.description }</td>
<td><a href="delete?umid=${ob.uomId }">DELETE</a>
</td>
<td>
<a href="edit?umid=${ob.uomId}">EDIT</a>
</td>
<td>
<a href="view?umid=${ob.uomId}">VIEW</a>
</td>
</tr>

</c:forEach>
</table>
</c:when>
<c:otherwise>
<H4>NO DATA FOUND!!</H4>
</c:otherwise>
</c:choose>
 <a href="register">Previous</a>
</div>
<c:if test="${!empty message }">
<div class="card-footer bg-info text-white text-center">
<b>${message }</b>
</div>
</c:if>
</div><!-- card end -->
</div><!-- container end -->
</body>
</html>