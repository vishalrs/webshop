<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html lang="en">
<head>
<title><spring:message code="label.title" />New Picture</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">New Picture</h3>
					</div>
					<div class="panel-body">
						<form:form cssClass="form-horizontal" method="post" modelAttribute="picture"  enctype="multipart/form-data">
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">Name</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="name"/>
									<p><form:errors path="name" cssClass="error"/></p>
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">Description</label>
								<div class="col-sm-8">
									<form:input cssClass="form-control" path="description"/>
								</div>
							</div>
							<div class="form-group">
								<label for="product" class="col-sm-2 control-label">Product</label>
								<div class="col-sm-4">
									<form:select cssClass="form-control" path="product">
										<form:options items="${products}" itemLabel="name" itemValue="id"/>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label for="file" class="col-sm-2 control-label">Picture File</label>
								<div class="col-sm-4">
									<input type="file" id="file" name="file" class="form-control"/>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-1">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
								<div class="col-sm-offset-3 col-sm-1">
									<button type="button" class="btn btn-default">
										<a href="../pictures.htm">Cancel</a>
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>