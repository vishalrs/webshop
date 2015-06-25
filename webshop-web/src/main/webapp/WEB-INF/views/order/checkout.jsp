<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" />Order - Checkout</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
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
							<c:if test="${empty cart}">
								<option value="0">Cart is empty</option>
							</c:if>
							<c:forEach items="${cart.products}" var="cart_product" varStatus="index">
								<c:set var="product" value="${cart_product.key}"/>
								<c:set var="qty" value="${cart_product.value}"/>
								<tr>
									<td><c:out value="${index.count}." /></td>
									<td>${product.code}</td>
									<td>${product.name}</td>
									<td>${qty}</td>
									<td><fmt:formatNumber value="${product.price}"
											maxFractionDigits="2" /></td>
									<td><fmt:formatNumber value="${product.price * qty}"
											maxFractionDigits="2" /></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="6">
									<h4 class="pull-right">Order Total: ${cart.orderTotal}</h4>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Shipping Details</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" action="confirm.htm" method="post">
							<input type="hidden" id="id" name="id" value="${auth_user.id}">
							<div class="form-group">
								<label for="firstName" class="col-sm-2 control-label">Name</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="firstName"
										placeholder="First Name" value="${auth_user.firstName}">
								</div>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="lastName"
										placeholder="Last Name" value="${auth_user.lastName}">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-4">
									<input type="email" class="form-control" id="email"
										placeholder="Email" value="${auth_user.email}">
								</div>
							</div>
							<div class="form-group">
								<label for="address" class="col-sm-2 control-label">Address</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="address"
										name="address"
										placeholder="Apartment No, Building No/Name, Street Name" value="${auth_user.address}">
								</div>
							</div>
							<div class="form-group">
								<label for="city" class="col-sm-2 control-label">City</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="city" name="city"
										placeholder="City Name" value="${auth_user.city}">
								</div>
							</div>
							<div class="form-group">
								<label for="pin" class="col-sm-2 control-label">Pincode</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="pin" name="pin"
										placeholder="Pin" value="${auth_user.pincode}">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-1">
									<button type="submit" class="btn btn-primary">Confirm</button>
								</div>
								<div class="col-sm-1">
									<button type="submit" class="btn btn-default">
										<a href="cancel">Cancel</a>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>