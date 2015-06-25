<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Pagination Bar -->
<div id='paginationbar'>
  <ul class='pagination'>
      <li <c:out value="${page.firstPage ? 'class=disabled' : ''}" />>
        <c:if test="${page.firstPage}">
        	<span>First</span>
        </c:if>
        <c:if test="${not page.firstPage}">
        	<a href='${page.url}?page.page=1&page.size=${page.size}'>First</a>
        </c:if>
      </li>
      <li <c:out value="${page.hasPreviousPage ? '' : 'class=disabled'}" />>
      	<c:if test="${not page.hasPreviousPage}">
        	<span>«</span>
        </c:if>
        <c:if test="${page.hasPreviousPage}">
        	<a href="${page.url}?page.page=${page.number-1}&page.size=${page.size}">«</a>
		</c:if>        
      </li>
      <c:forEach var="item" items="${page.items}">
      	<li <c:out value="${item.current ? 'class=active' : ''}" />>
      	<c:if test="${item.current}">
      		<span>${item.number}</span>
      	</c:if> 
      	<c:if test="${not item.current}">
      		<a href="${page.url}?page.page=${item.number}&page.size=${page.size}"><span>${item.number}</span></a>
      	</c:if>
      </c:forEach>
      <li <c:out value="${page.hasNextPage ? '' : 'class=disabled'}" />>
      	<c:if test="${not page.hasNextPage}">
        	<span>»</span>
        </c:if>
        <c:if test="${page.hasNextPage}">
        	<a href="${page.url}?page.page=${page.number+1}&page.size=${page.size}">»</a>
		</c:if>        
      </li>
     <li class='<c:out value="${page.lastPage ? 'disabled' : ''}" />'>
        <c:if test="${page.lastPage}">
        	<span>Last</span>
        </c:if>
        <c:if test="${not page.lastPage}">
        	<a href='${page.url}?page.page=${page.totalPages}&page.size=${page.size}'>Last</a>
        </c:if>
      </li>
   </ul>
</div>