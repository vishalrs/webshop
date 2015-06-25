<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Product Pictures</h3>
				</div>
				<div class="panel-body">
					<div class="pull-right">
						<span class="glyphicon glyphicon-plus"></span><a href="pictures/new.htm"><b>New Picture</b></a>
					</div>
					<p>&nbsp;</p>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th class="text-center">Name</th>
								<th class="text-center">Product</th>
								<th class="text-center">Content Type</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="picture" items="${page.content}">
								<tr>
									<td>${picture.name}</td>
									<td>${picture.product.name}</td>
									<td>${picture.contentType}</td>
									<td><a data-toggle="modal" href="pictures/show.htm?pic_id=${picture.id}" data-target="#myModal">Show</a> | <a href="pictures/edit.htm?pic_id=${picture.id}">Edit</a> | <a href="#" onclick="resp = confirm('Are you sure you want to delete this picture?'); if(resp){document.getElementById('form_pic_delete').submit();}">
									                Delete
									        </a> 
										<form id="form_pic_delete" action="pictures/delete.htm" method="post">
											<input type="hidden" name="_method" value="DELETE">
											<input type="hidden" name="pic_id" id="pic_id" value="${picture.id}">
										</form>
										    <!-- Modal HTML -->
										    <div class="modal fade" id="myModal" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content"></div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
											</div> <!-- /.modal -->
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
		</div>
	</div>
	<div class="row">
		<div class="center-block">
			<jsp:include page="/resources/common/pagination_bar.jsp"></jsp:include>
		</div>
	</div>
</div>
</body>
</html>
