<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" />New User</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">New User</h3>
					</div>
					<div class="panel-body">
						<form:form cssClass="form-horizontal"  method="post" modelAttribute="user">
 						    <div class="form-group">
								<label for="firstName" class="col-sm-2 control-label">Name</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="firstName" placeholder="First Name"/>
								</div>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="lastName" placeholder="Last Name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-2 control-label">Email</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="email" placeholder="Email"/>
								</div>
							</div>
							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">Username</label>
								<div class="col-sm-4">
									<form:input path="username" cssClass="form-control" placeholder="Username"/>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">Password</label>
								<div class="col-sm-4">
									<form:password path="password" cssClass="form-control" placeholder="Password"/>
								</div>
							</div>							
							<div class="form-group">
								<label for="address" class="col-sm-2 control-label">Address</label>
								<div class="col-sm-8">
									<form:input cssClass="form-control" path="address"
										placeholder="Apartment No, Building No/Name, Street Name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="city" class="col-sm-2 control-label">City</label>
								<div class="col-sm-4">
									<form:input cssClass="form-control" path="city" placeholder="City Name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="pin" class="col-sm-2 control-label">Pincode</label>
								<div class="col-sm-4">
									<form:input  cssClass="form-control" path="pincode" placeholder="Pincode"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="pin" class="col-sm-2 control-label">Role</label>
								<div class="col-sm-4">
									<form:select path="roles" items="${roles}" itemLabel="name" itemValue="id" multiple="false" cssClass="form-control"></form:select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-1">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
								<div class="col-sm-offset-3 col-sm-1">
									<button type="submit" class="btn btn-default">
										<a href="../users.htm">Cancel</a>
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