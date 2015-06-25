<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Orders</h3>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="text-center">Order No</th>
								<th class="text-center">Order Date</th>
								<th class="text-center">Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="order" items="${page.content}">
								<tr>
									<td>${order.orderNo}</td>
									<td>${order.orderDate}</td>
									<td>${order.status}</td>
									<td><a href="orders/show.htm?order_id=${order.id}">View</a>&nbsp;|&nbsp;<a href="orders/edit.htm?order_id=${order.id}">Edit</a></td>
								</tr>
							</c:forEach>
							<c:if test="${empty page.content}">
								<h4>No Results Found!</h4>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<jsp:include page="/resources/common/pagination_bar.jsp"></jsp:include>
		</div>
	</div>
</div>

