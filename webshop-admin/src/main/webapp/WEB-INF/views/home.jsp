<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="label.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- <div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Module</h3>
					</div>
					<div class="panel-body">
						<form class="navbar-form navbar-right" role="form" action="search"
							method="get">
							<div class="form-group">
								<input type="text" class="form-control" id="value" name="value" placeholder="Search by name">
							</div>
							<button type="submit" class="btn btn-default">Search</button>
						</form>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Product</th>
									<th class="text-center">Qty</th>
									<th class="text-center">Price</th>
									<th> </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${products}">
									<form method="post" action="addProduct">
									<tr>
										<td class="col-sm-8 col-md-6">
											<div class="media">
												<div class="media-body">
													<h5 class="media-heading">
														<a href="#">${product.name}</a>
													</h5>
													<h6 class="media-heading">
														<a href="#">${product.description}</a>
													</h6>
												</div>
											</div>
										</td>
										<td class="col-md-1" style="text-align: center"><input
											type="text" class="form-control" id="qty" name="qty"
											value="1"></td>
										<td class="col-md-1 text-center"><strong>${product.price}</strong></td>
										<td class="col-md-1">

											<button type="submit" class="btn btn-info">
												<span class="glyphicon glyphicon-add"></span>Add to Cart
											</button> <input type="hidden" id="product_id" name="product_id"
											value="${product.id}">
										</td>
									</tr>
									</form>
								</c:forEach>
								<c:if test="${empty products}">
									<h4>No Results Found!</h4>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>
