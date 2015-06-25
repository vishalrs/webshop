<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="label.title" /></title>
<style type="text/css" media="screen">
.login {
	padding-top: 65px;
}

.center {
	float: none;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
		<div class="container">
			<div class="row ">
			<div class="col-md-4 col-md-offset-4 well">
					<c:if test="${param.error==1}">
						<div class="alert alert-danger" role="alert">
							<b>Username/Password you entered is wrong. Please try again.</b>
						</div>
					</c:if>
					<c:if test="${param.error==2}">
						<div class="alert alert-danger" role="alert">
							<b>You are not authorized to view this site.</b>
						</div>
					</c:if>
					<legend>Please Sign In</legend>
					<form method="POST" action="j_spring_security_check" role="form">
						<div class="form-group">
							<label for="username">Username</label> 
							<input type="text" class="form-control" id="j_username" name="j_username" autofocus>
						</div>
						<div class="form-group">
							<label for="password">Password</label> 
							<input type="password"	class="form-control" id="j_password" name="j_password">
						</div>
						<button type="submit" id="submit"name="submit" class="btn btn-primary">Sign in</button>
					</form>
					</div>
				</div>
			</div>
</body>
</html>