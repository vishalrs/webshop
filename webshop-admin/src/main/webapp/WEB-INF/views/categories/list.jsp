<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Product Categories</h3>
				</div>
				<div class="panel-body">
					<div class="pull-right">
						<span class="glyphicon glyphicon-plus"></span><a href="categories/new.htm"><b>New Category</b></a>
					</div>
					<p>&nbsp;</p>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="text-center">ID</th>
								<th class="text-center">Name</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="category" items="${page.content}">
								<tr>
									<td><a href="#">${category.id}</a></td>
									<td>${category.name}</td>
									<td><a href="categories/edit.htm?cat_id=${category.id}">Edit</a> | <a href="categories/del.htm?cat_id=${category.id}" onclick="resp = confirm('Are you sure you want to delete this category?'); return resp;">Delete</a></td>
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

