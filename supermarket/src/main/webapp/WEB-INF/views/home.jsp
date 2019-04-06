<link rel="stylesheet" href="${cssCustom}/main_page.css">
<script src="${jsLinked}/angular.js"></script>
<script src="${jsCustom}/homeProductsController.js"></script>
<header>
	<div class="container">

		<!-- Home page titles -->
		<div class="titles">
			<div class="top_title">
				Fresh Fruits<br> From Around the World
			</div>
			<div class="second_title">
				Explore our collections of fruits from europe, <br> asia and
				south america
			</div>
		</div>
	</div>
</header>

<!-- First section of Europe products -->
<div ng-app="ShoppingApp" ng-controller="ProductController as contr">
<section>
	<div class="container">

		<h2>Europe Most Popular</h2>

		<div class="row" ng-init="contr.fetchEuropeProducts()">
			<div class="col-lg-4" ng-repeat="product in contr.europeProducts">
			
				<div class="col-lg-12">

						<div class="frame">
							<img src="${imgProducts}/{{product.code}}.jpg"
								alt="{{product.name}}">
							<p class="product-name">{{product.name}}</p>
							<div class="frame-menu">

								<div class="row">

									<div class="col-md-12 text-center">
										<table>
											<tr>
												<td>{{product.variety}}</td>
												<td><a class="btn btn-success btn-more"
													ng-href="${contextRoot}/show/{{product.id}}/product">More</a></td>
											</tr>
											<tr>
												<td>{{product.country}}</td>
												<td>Price: &#163;{{product.price}}</td>
											</tr>
										</table>
									</div>

								</div>
								<!-- End of row -->

								<div class="row add-product">
									<div class="col-md-12">
										<a class="btn btn-success btn-add"
											ng-href="${contextRoot}/cart/add/{{product.id}}/product">Add
											to Basket</a>
									</div>
								</div>

							</div>
						</div><!-- End of frame -->

					</div>
				
			</div><!-- End Col-4 -->
			
		</div>

	</div>
</section>

<section>
	<div class="container">

		<h2>Asia Most Popular</h2>

		<div class="row" ng-init="contr.fetchAsiaProducts()">
			<!-- 4th Product Frame -->
			<div class="col-lg-4" ng-repeat="product in contr.asiaProducts">
			
				<div class="col-lg-12">
				
					<div class="frame">
						<img src="${imgProducts}/{{product.code}}.jpg" alt="{{product.name}}">
						<p class="product-name">{{product.name}}</p>
						<div class="frame-menu">

								<div class="row">

									<div class="col-md-12 text-center">
										<table>
											<tr>
												<td>{{product.variety}}</td>
												<td><a class="btn btn-success btn-more"
													ng-href="${contextRoot}/show/{{product.id}}/product">More</a></td>
											</tr>
											<tr>
												<td>{{product.country}}</td>
												<td>Price: &#163;{{product.price}}</td>
											</tr>
										</table>
									</div>

								</div>
								<!-- End of row -->

								<div class="row add-product">
									<div class="col-md-12">
										<a class="btn btn-success btn-add"
											ng-href="${contextRoot}/cart/add/{{product.id}}/product">Add
											to Basket</a>
									</div>
								</div>

							</div>
					</div><!-- End of frame -->
					
				</div>
				
			</div><!-- End Col-4 -->
			

		</div>
	</div>
</section>

<section>
	<div class="container">

		<h2>South America Most Popular</h2>

		<div class="row" ng-init="contr.fetchSAProducts()">
			<!-- 7th Product Frame -->
			<div class="col-lg-4" ng-repeat="product in contr.saProducts">
			
				<div class="col-lg-12">

						<div class="frame">
							<img src="${imgProducts}/{{product.code}}.jpg"
								alt="{{product.name}}">
							<p class="product-name">{{product.name}}</p>
							<div class="frame-menu">

								<div class="row">

									<div class="col-md-12 text-center">
										<table>
											<tr>
												<td>{{product.variety}}</td>
												<td><a class="btn btn-success btn-more"
													ng-href="${contextRoot}/show/{{product.id}}/product">More</a></td>
											</tr>
											<tr>
												<td>{{product.country}}</td>
												<td>Price: &#163;{{product.price}}</td>
											</tr>
										</table>
									</div>

								</div>
								<!-- End of row -->

								<div class="row add-product">
									<div class="col-md-12">
										<a class="btn btn-success btn-add"
											ng-href="${contextRoot}/cart/add/{{product.id}}/product">Add
											to Basket</a>
									</div>
								</div>

							</div>
						</div>
						<!-- End of frame -->

					</div>
				
			</div><!-- End Col-4 -->
			
		</div>

	</div>
</section>
</div>