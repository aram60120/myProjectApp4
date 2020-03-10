<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<H3>WELCOME TO SHIPMENT TYPE DATA</H3> 
</div>
<div class="card-body">
<a href="excel"><img src="../resources/images/excel.png"  width="60" height="60"/>
	excel</a>
	<a href="pdf"><img src="../resources/images/pdf.png" width="60"  height="60"/>pdf</a>
		<c:choose>
		<c:when test="${!empty list }">
                <table border="table table-hover">
                 <tr class="bg-success text-white">
               
                      <th>ID</th>
                      <th>MODE</th>
                      <th>CODE</th>
                      <th>ENABLE</th>
                      <th>GRADE</th>
                      <th>NOTE</th>
                      <th colspan="3">OPERATION</th>
                           </tr>     
                      
                             <c:forEach items="${list  }" var="ob">
                      <tr>
                          <td>${ob.shipId }</td>
                          <td>${ob.shipMode }</td>
                          <td>${ob.shipCode }</td>
                          <td>${ob.enbShip }</td>
                          <td>${ob.shipGrad }</td>
                          <td>${ob.shipDesc }</td>
                        <td> <a href="delete?sid=${ob.shipId }"> <img src="../resources/images/delete.png" width="30" height="30"/>delete </a> </td>
                        <td> <a href="edit?sid=${ob.shipId}"><img src="../resources/images/edit.jpg" width="30" height="30"/>edit </a> </td>
                       <td><a href="view?sid=${ob.shipId}"><img src="../resources/images/view.png" width="30" height="30"/> view</a></td>
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