<h3 class="my-4">Categories</h3>
<div class="list-group">

	<c:forEach items="${categories}" var="categories">
	
		<a href="${contextRoot}/show/category/${categories.id}/products" class="list-group-item" id="a_${categories.name}">${categories.name}</a>
		
	</c:forEach>

</div>