<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="label.title" /></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Categories</h3>
					</div>
					<div class="list-group">
						<c:forEach var="category" items="${categories}">
							<a href="search.htm?param=category&value=${category.id}"
								class="list-group-item">${category.name}</a>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Products</h3>
					</div>
					<div class="panel-body">
						<form class="navbar-form navbar-right" role="form" action="search.htm"
							method="get">
							<div class="form-group">
								<select class="form-control" id="param" name="param">
									<option value="name" ${param.param == 'name' ? 'selected' : ''}>Name</option>
									<option value="desc" ${param.param == 'desc' ? 'selected' : ''}>Description</option>
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="value" name="value">
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
									<form method="post" action="addProduct.htm">
									<tr>
										<td class="col-sm-8 col-md-6">
											<div class="media">
												<div class="media-body">
													<h5 class="media-heading">
														<a href="show_picture.htm?prod_id=${product.id}" data-toggle="modal" data-target="#myModal">${product.name}</a>
													</h5>
													<h6 class="media-heading">
														${product.description}
													</h6>
												</div>
											</div>
											<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"	aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content"></div>
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
										<td></td>
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
			</div>
			<div class="col-md-3">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="order/checkout.htm">Checkout</a>&nbsp;<span
								class="glyphicon glyphicon-shopping-cart pull-right"></span>
						</h3>
					</div>
					<ul class="list-group">
						<li class="list-group-item"><b>Order
								Subtotal:&nbsp;${cart.orderTotal}</b></li>
						<c:forEach items="${cart.products}" var="cart_product">
							<c:set var="product" value="${cart_product.key}" />
							<c:set var="qty" value="${cart_product.value}" />
							<li class="list-group-item"><span class="badge">${qty}</span>
								Name: ${product.name}, Price: <fmt:formatNumber
									value="${product.price}" maxFractionDigits="2" /> <a
								href="removeProduct.htm?product_id=${product.id}"><span
									class="glyphicon glyphicon-remove"></span></a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
