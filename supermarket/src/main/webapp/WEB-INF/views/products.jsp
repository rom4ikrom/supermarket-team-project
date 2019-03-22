<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${cssCustom}/products.css">
<section>

	<!-- Table with all products -->

	<div class="container">

		<div class="row">

			<!-- Side Bar Navigation -->
			<div class="col-lg-3">
				
				<%@include file="./shared/sidebar.jsp" %>

			</div>


			<div class="col-lg-9">

				<!-- Added a breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
					
					<c:if test="${userClickAllProducts == true}">
					
						<script>
							window.regionId = '';
						</script>
					
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickRegionProducts == true}">
					
						<script>
							window.regionId = '${region.id}';
						</script>
					
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Region</li>
							<li class="breadcrumb-item active">${region.name}</li>
						</ol>
					</c:if>
					
					</div>

				</div>

				<!-- Product Table -->
				<div class="row">
					<div class="col-md-12">

						<div class="table-responsive">

							<table id="productListTable"
								class="table table-stripe table-bordered">

								<thead>

									<tr>
										<th><!-- Image --></th>
										<th>Name</th>
										<th>Variety</th>
										<th>Country</th>
										<th>Price 1kg</th>
										<th>Qty</th>
										<th><!-- Control Buttons --></th>

									</tr>

								</thead>

								<tfoot>

									<tr>
										<th><!-- Image --></th>
										<th>Name</th>
										<th>Variety</th>
										<th>Country</th>
										<th>Price 1kg</th>
										<th>Qty</th>
										<th><!-- Control Buttons --></th>

									</tr>

								</tfoot>

							</table>
						</div>

					</div>
				</div>


			</div>

		</div>

	</div>

</section>
