<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Products</h3>
				</div>
				<div class="panel-body">
					<div class="pull-right">
						<span class="glyphicon glyphicon-plus"></span><a href="products/new.htm"><b>New Product</b></a>
					</div>
					<p>&nbsp;</p>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="text-center">Code</th>
								<th class="text-center">Name</th>
								<th class="text-center">Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${page.content}">
								<tr>
									<td>${product.code}</td>
									<td>${product.name}</td>
									<td>${product.price}</td>
									<td><a href="products/edit.htm?prod_id=${product.id}">Edit</a> | <a href="products/del.htm?prod_id=${product.id}" onclick="resp = confirm('Are you sure you want to delete this product?'); return resp;">Delete</a></td>
								</tr>
							</c:forEach>
							<c:if test="${empty page.content}">
								<h4>No Results Found!</h4>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="center-block">
			<jsp:include page="/resources/common/pagination_bar.jsp"></jsp:include>
		</div>
	</div>
</div>

