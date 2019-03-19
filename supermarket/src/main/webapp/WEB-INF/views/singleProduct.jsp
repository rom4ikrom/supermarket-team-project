<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="container">
	
		<div class="row">
			<div class="col-md-12">

				<ol class="breadcrumb">
					<li class="breadcrumb-item">
						<a href="${contextRoot}/home">Home</a>
					</li>
					<li class="breadcrumb-item">
						<a href="${contextRoot}/show/all/products">Products</a>
					</li>
					<li class="breadcrumb-item active">
						${product.name} ${product.variety}
					</li>
				</ol>
				
			</div>
		</div><!-- End of row -->
		
		<div class="row">
		
			<div class="col-md-4">
				<img src="${imgProducts}/${product.code}.jpg" class="img img-fluid"/>	
			</div>
			
			<div class="col-md-8">
				<h3>${product.name} ${product.variety}</h3>
				
				<p>${product.description}</p>
				
				<p>Price: &#163; ${product.price}</p>
				
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<p>Qnty: <span style="color:red">Out of Stock</span>
					</c:when>
					<c:otherwise>
						<p>Qnty: ${product.quantity}</p>
					</c:otherwise>
				</c:choose>
				
				<!-- Add control buttons -->
				
			</div>
			
		</div><!-- End of row -->
		
	</div>
</section>