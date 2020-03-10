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
<H3>WELCOME TO ORDERMETHODDATATYPE TYPE DATA</H3> 
</div>
<div class="card-body">
<a href="excel">excel</a>
<a href="pdf">pdf</a>
		<c:choose>
		<c:when test="${!empty list }">
                <table border="table table-hover">
                 <tr class="bg-success text-white">
               
                      <th>ORDERID</th>
                      <th>ORDERMODE</th>
                      <th>ORDERCODE</th>
                      <th>ORDERTYPE</th>
                      <th>ORDERACCEPT</th>
                      <th>DESCRIPTION</th>
                      <th colspan="3">OPERATION</th>
                           </tr>     
                      
                             <c:forEach items="${list  }" var="ob">
                      <tr>
                          <td>${ob.orderId }</td>
                          <td>${ob.orderMode }</td>
                          <td>${ob.orderCode }</td>
                          <td>${ob.orderType }</td>
                          <td>${ob.orderAccept }</td>
                          <td>${ob.description }</td>
                          <td>
                          <a href="delete?ordid=${ob.orderId}">DELETE </a>
                               </td>
                               <td>
                               <a href="edit?ordid=${ob.orderId}">EDIT</a>
                               </td>
                               <td>
                               <a href="view?ordid=${ob.orderId}">View</a>
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