<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 


<div class="list-group" style="margin-top: 120px;">

	<a href="${contextRoot}/show/all/products" class="list-group-item" id="a_all">All</a>
	
	
	<c:forEach items="${regions}" var="region">
		<a href="${contextRoot}/show/region/${region.id}/products" class="list-group-item" id="a_${fn:replace(region.name, ' ', '')}">${region.name}</a>
	</c:forEach>
	
</div>