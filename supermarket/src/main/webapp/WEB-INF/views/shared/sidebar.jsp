<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<h1 class="my-4">Shop Name</h1>



<div class="list-group">

	<a href="${contextRoot}/show/all/products" class="list-group-item" id="a_all">All</a>
	
	
	<c:forEach items="${regions}" var="region">
		<a href="${contextRoot}/show/region/${region.id}/products" class="list-group-item" id="a_${fn:replace(region.name, ' ', '')}">${region.name}</a>
	</c:forEach>
	
</div>