<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${css}/products.css">
<section>

	<!-- Table with all products -->

	<div class="container">

		<div class="row">

			<!-- Side Bar Navigation -->
			<div class="col-md-3">
				
				<%@include file="./shared/sidebar.jsp" %>

			</div>


			<div class="col-md-9">

				<!-- Added a breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
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
										<th>Price</th>
										<th>Qty. Available</th>
										<th><!-- Control Buttons --></th>

									</tr>

								</thead>

								<tfoot>

									<tr>
										<th><!-- Image --></th>
										<th>Name</th>
										<th>Variety</th>
										<th>Country</th>
										<th>Price</th>
										<th>Qty. Available</th>
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
