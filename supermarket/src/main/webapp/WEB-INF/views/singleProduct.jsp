<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
				
				<div class="description">
					<h4>Product Description</h4>
					<p>${product.description}</p>
				</div>
				
				<h4>Price: &#163;${product.price}</h4>
				
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<h5>Qnty: <span style="color:red">Out of Stock</span></h5>
					</c:when>
					<c:otherwise>
						<h5>Qnty in kg: ${product.quantity}</h5>
					</c:otherwise>
				</c:choose>
				
				<!-- Add control buttons -->
				<security:authorize access="hasAuthority('USER')">
					<c:choose>
						<c:when test="${product.quantity < 1 }">
	
							<a href="javascript:void(0)" class="btn btn-success disabled">
								<span class="fa fa-shopping-cart"> Add to Cart</span>
							</a>
	
						</c:when>
						
						<c:otherwise>
							<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
								<span class="fa fa-shopping-cart"></span> Add to Cart
							</a>
						</c:otherwise>
					</c:choose>
				</security:authorize>
				
				<security:authorize access="hasAuthority('ADMIN')">
					<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-warning">
						<span class="fa fa-pencil"></span>Edit
					</a>
				</security:authorize>
				
				<a class="btn btn-warning" href="${contextRoot}/show/all/products">Back</a>
				
			</div>
			
		</div><!-- End of row -->
		
	</div>
</section>