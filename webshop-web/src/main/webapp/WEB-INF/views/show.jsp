<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Product Picture</title>
<script type="text/javascript">
	$('body').on('hidden.bs.modal', '.modal', function () {
		$(this).removeData('bs.modal');
	});
</script>
</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h4 class="modal-title">Picture</b></h4>
	</div>
	<!-- /modal-header -->
	<div class="modal-body">
		<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Picture Details</h3>
					</div>
					<c:forEach items="${pictures}" var="picture">
						<p><img src="content.htm?pic_id=${picture.id}" width="250" height="250"/></p>
					</c:forEach>
				</div>
	</div>
	<!-- /modal-body -->
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	</div>
	<!-- /modal-footer -->
</body>
</html>