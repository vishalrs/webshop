<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Users</h3>
				</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="text-center">First Name</th>
								<th class="text-center">Last Name</th>
								<th class="text-center">Email</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${page.content}">
								<tr>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.email}</td>
									<td><a href="users/show.htm?user_id=${user.id}">View</a>&nbsp;|&nbsp;<a href="users/edit.htm?user_id=${user.id}">Edit</a>&nbsp;|&nbsp;
										<a href="users/del.htm?user_id=${user.id}" onclick="resp = confirm('Are you sure you want to delete this user?'); return resp;">Delete</a>
									</td>
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

