<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" />Order - History</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Order History</h3>
					</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Sr.No</th>
								<th>Order No</th>
								<th>Order Date</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty cart}">
								<option value="0">No Orders</option>
							</c:if>
							<c:forEach items="${history_orders}" var="order"
								varStatus="index">
								<tr>
									<td><c:out value="${index.count}." /></td>
									<td>${order.orderNo}</td>
									<td>${order.orderDate}</td>
									<td>${order.status}</td>
									<td><a data-toggle="modal" class="btn btn-info"
										href="details.htm?orderno=${order.orderNo}" data-target="#myModal">Details</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content"></div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div> <!-- /.modal -->
				</div>
				<a href="../">Back to Home</a>
			</div>
		</div>
	</div>

</body>
</html>