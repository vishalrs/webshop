<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<head>
<title><decorator:title default='Welcome to Webshop' /></title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" rel = "stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/resources/css/shop-homepage.css" rel="stylesheet" rel= "stylesheet" media="screen">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
</head>
<body>
	      
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">Welcome to Webshop</a>
			</div>
			<sec:authorize access="isAuthenticated()"  var="isAuthenticated"/>
			<c:if test="${not isAuthenticated}">
			
			<form class="navbar-form navbar-right" role="form" action='<spring:url value="/j_spring_security_check" htmlEscape="true"/>' method="post">
				<div class="form-group">
					<input type="text" id="j_username" name="j_username" placeholder="Username" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" id="j_password" name="j_password" placeholder="Password" class="form-control">
				</div>
				<button type="submit" class="btn btn-primary">Sign In</button>
				<a href="new.htm">Register Now!</a>
			</form>
			</c:if>
			<sec:authorize access="isAuthenticated()">
				<div class="pull-right">
    				<span class="navbar-brand"><a href='${pageContext.request.contextPath}/order/history.htm?name=<sec:authentication property="principal.username"/>'>My Orders</a>&nbsp;| Welcome <sec:authentication property="principal.username"/>&nbsp;|&nbsp;<a href="<c:url value="/j_spring_security_logout" />">Logout</a></span>
    			</div>
			</sec:authorize>
			
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	      
	<div id="content">
		        
		<decorator:body />
		    
	</div>
	      
	<div class="container">
		<hr>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>
						Copyright &copy; Company 2013</a>
					</p>
				</div>
			</div>
		</footer>
	</div>
	<!-- /.container -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	 
</body>
</html>