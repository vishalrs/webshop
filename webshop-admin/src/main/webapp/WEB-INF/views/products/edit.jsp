<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html lang="en">
<head>
<title><spring:message code="label.title" />Edit Product</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Edit Product: Product Code : ${product.code}</h3>
					</div>
					<div class="panel-body">
						<form:form cssClass="form-horizontal"  method="post" modelAttribute="product">
							<form:hidden path="id" value="${product.id}"/>
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">Name</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="name" value="${product.name}"/>
									<p><form:errors path="name" cssClass="error"/></p>
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">Description</label>
								<div class="col-sm-4">
									<form:input path="description" cssClass="form-control" value="${product.description}"/>
									<p><form:errors path="description" cssClass="error"/></p>
								</div>
							</div>
							<div class="form-group">
								<label for="price" class="col-sm-2 control-label">Price</label>
								<div class="col-sm-4">
									<form:input path="price" cssClass="form-control" value="${product.price}"/>
									<p><form:errors path="price" cssClass="error"/></p>
								</div>
							</div>							
							<div class="form-group">
								<label for="pin" class="col-sm-2 control-label">Product Category</label>
								<div class="col-sm-4">
									<form:select path="productCategory" multiple="false" cssClass="form-control">
										<form:options items="${categories}" itemLabel="name" itemValue="id"/>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-1">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
								<div class="col-sm-offset-3 col-sm-1">
									<button type="button" class="btn btn-default">
										<a href="../products.htm">Cancel</a>
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