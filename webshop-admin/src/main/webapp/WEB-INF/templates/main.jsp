<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false"%>

<html lang="en">
<head>
<title><decorator:title default='Welcome to Webshop-Admin' /></title>
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
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/home.htm">Welcome to Webshop Administration</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				<sec:authorize access="isAuthenticated()">
				  <li class="dropdown">
				    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-th-large">&nbsp;</span><b>Manage</b><span class="caret"></span></a>
				    <ul class="dropdown-menu" role="menu">
				      <li><a href="${pageContext.request.contextPath}/categories.htm">Product Category</a></li>
				      <li><a href="${pageContext.request.contextPath}/products.htm">Products</a></li>
				      <li><a href="${pageContext.request.contextPath}/users.htm">Users</a></li>
				      <li><a href="${pageContext.request.contextPath}/orders.htm">Orders</a></li>
				      <li><a href="${pageContext.request.contextPath}/pictures.htm">Pictures</a></li>
				    </ul>
				  </li>
				  </sec:authorize>
				</ul>
				<sec:authorize access="isAuthenticated()">
					<ul class="nav navbar-nav navbar-right">
							<li class="active"><a>Welcome&nbsp;<sec:authentication property="principal.username"/></a></li>
							<li class="active"><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
					</ul>
				</sec:authorize>
        </div>

			
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</div>
	      
	<div id="content">
		<decorator:body />
	</div>
	      
	<div class="container">
		<hr>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>
						<a>Copyright &copy; Company 2014</a>
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