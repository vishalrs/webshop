<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Remote file for Bootstrap Modal</title>
</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h4 class="modal-title">Order - <b>${order.orderNo}</b></h4>
	</div>
	<!-- /modal-header -->
	<div class="modal-body">
		<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Product Details</h3>
					</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Sr.No</th>
								<th>Product Name</th>
								<th>Qty</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order.orderLines}" var="order_line"varStatus="index">
								<tr>
									<td><c:out value="${index.count}." /></td>
									<td>${order_line.product.name}</td>
									<td>${order_line.qty}</td>
									<td>${order_line.price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
	</div>
	<!-- /modal-body -->
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	</div>
	<!-- /modal-footer -->
</body>
</html>