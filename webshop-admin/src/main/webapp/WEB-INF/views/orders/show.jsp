<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" />View Order</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">View Order - No: ${order.orderNo}</h3>
					</div>
					<div class="panel-body">
						<form:form cssClass="form-horizontal" method="post" modelAttribute="order">
 						    <div class="form-group">
								<label for="firstName" class="col-sm-2 control-label">Order No.</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="orderNo" value="${order.orderNo}" readonly="true"/>
								</div>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="orderDate" value="${order.orderDate}" readonly="true"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="pin" class="col-sm-2 control-label">Status</label>
								<div class="col-sm-4">
									<form:select path="status" multiple="false" cssClass="form-control" readonly="true">
										<form:options items="${statuses}" />
									</form:select>
								</div>
							</div>
							<legend><h5>Shipping Details</h5></legend>
							<div class="form-group">
								<label for="firstName" class="col-sm-2 control-label">First Name</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="user.firstName" value="${order.user.firstName}" readonly="true"/>
								</div>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="user.lastName" value="${order.user.lastName}" readonly="true"/>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="user.email" value="${order.user.email}" readonly="true"/>
								</div>
							</div>
							<div class="form-group">
								<label for="shippingAddress" class="col-sm-2 control-label">Shipping Address</label>
								<div class="col-sm-8">
									<form:input path="shippingAddress" cssClass="form-control"  value="${order.shippingAddress}" readonly="true"/>
								</div>
							</div>
							<div class="form-group">
								<label for="shippingCity" class="col-sm-2 control-label">Shipping City</label>
								<div class="col-sm-4">
									<form:password path="shippingCity" cssClass="form-control" value="${order.shippingCity}" readonly="true"/>
								</div>
							</div>							
							<div class="form-group">
								<label for="shippingPin" class="col-sm-2 control-label">Pincode</label>
								<div class="col-sm-4">
									<form:input  path="shippingPin" cssClass="form-control" value="${order.shippingPin}" readonly="true"/>
								</div>
							</div>
						</form:form>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">Order Summary</h3>
							</div>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Sr.No</th>
										<th>Product Code</th>
										<th>Product Name</th>
										<th>Qty</th>
										<th>Price/Unit</th>
										<th>Unit Total</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty order.orderLines}">
										<option value="0">No Orderlines!</option>
									</c:if>
									<c:forEach items="${order.orderLines}" var="line" varStatus="index">
										<tr>
											<td><c:out value="${index.count}." /></td>
											<td>${line.product.code}</td>
											<td>${line.product.name}</td>
											<td>${line.qty}</td>
											<td><fmt:formatNumber value="${line.price}"
													maxFractionDigits="2" /></td>
											<td><fmt:formatNumber value="${line.price * line.qty}"
													maxFractionDigits="2" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div style="text-align: center !important;">
							<button type="submit" class="btn btn-default">
								<a href="../orders.htm">Cancel</a>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>