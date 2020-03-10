<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div
				class="card-header  bg-primary text-center text-white text-uppercase">
				<H3>WELCOME TO SHIPMENT TYPE REGISTER PAGE</H3>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="orderMethodType" >
					<div class="row">
						<div class="col-4">
							<label for="orderMode">ORDER MODE</label>
						</div>
						<div class="col-4">
							<form:radiobutton  path="orderMode"  value="Sale"/>Sale
							<form:radiobutton  path="orderMode"  value="Purchase"/>Purchase
						</div>
						
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="class-4">
							<label for="orderCode">ORDERCODE</label>
						</div>
						<div class="col-4">
							<form:input path="orderCode" class="form-control" />
						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderType">ORDERTYPE</label>
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
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderAccept">ORDERACCEPT</label>
						</div>
						<div class="col-4">
							<form:checkbox path="orderAccept" value="multi-model" />
							MultiModel
							<form:checkbox path="orderAccept" value="multi-return" />
							MultiReturn


						</div>
						<div class="col-4">
							<!-- Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="description">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="description" class="form-control" />
						</div>
						<div class="col-4">
							<!--    Error message -->
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<input type="submit" value="create" class=" btn btn-succes" /> <input
								type="reset" value="clear" class=" btn btn-danger" />
						</div>

					</div>

				</form:form>
			</div>
			<c:if test="${!empty message }">
				<div class="card-footer  bg-info text-white text-center">
					<b>${message} </b>
				</div>
			</c:if>
		</div>
		<!-- card end -->
	</div>
	<!-- container -->
</body>
</html>