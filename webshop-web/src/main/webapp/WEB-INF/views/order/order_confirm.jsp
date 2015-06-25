<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" />Order - Checkout</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Order Summary</h3>
					</div>
					<div class="panel-body">
						Thank you. Your order no <b>${order_no}</b> has been confirmed.
					</div>
				</div>
			</div>
		</div>
	</div>
</body>