<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" />Edit Category</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Edit User - ID: ${category.id}</h3>
					</div>
					<div class="panel-body">
						<form:form cssClass="form-horizontal"  method="post" modelAttribute="category">
							<form:hidden path="id" value="${category.id}"/>
 						    <div class="form-group">
								<label for="name" class="col-sm-2 control-label">Product Category Name</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="name" value="${catgeory.name}"/>
									<p><form:errors path="name" cssClass="error"/></p>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-1">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
								<div class="col-sm-offset-3 col-sm-1">
									<button type="submit" class="btn btn-default">
										<a href="../categories.htm">Cancel</a>
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