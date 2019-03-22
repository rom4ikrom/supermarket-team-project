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
			<!-- First Product Frame-->
			<div class="col-lg-4" ng-repeat="product in contr.europeProducts">
			
				<div class="col-lg-12">
				
					<div class="frame">
						<img src="${imgProducts}/{{product.code}}.jpg" alt="{{product.name}}">
						<p class="product_name">{{product.name}}</p>
						<div class="frame_menu">
						
							<div class="row">
								
								<!-- Information about fruit country and fruit price -->
								<div class="col-6">
									<ul class="country_price">
										<li class="country_name">{{product.variety}}</li>
										<li>{{product.country}}</li>
									</ul>
								</div>
								<div class="col-6">
									<!-- Link to page about one fruit and quantity chooser -->
									<ul class="more_qnty">
										<li>
											<div class="more_info">
												<a ng-href="${contextRoot}/show/{{product.id}}/product">More</a>
											</div>
										</li>
										<li>Price: &#163;{{product.price}}</li>
									</ul>
									<!-- Add item to the basket -->
								</div>
								<div class="button btn_add_item">
									<a ng-href="${contextRoot}/cart/add/{{product.id}}/product">Add to Basket</a>
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
						<p class="product_name">{{product.name}}</p>
						<div class="frame_menu">
						
							<div class="row">
								
								<!-- Information about fruit country and fruit price -->
								<div class="col-6">
									<ul class="country_price">
										<li class="country_name">{{product.variety}}</li>
										<li>{{product.country}}</li>
									</ul>
								</div>
								<div class="col-6">
									<!-- Link to page about one fruit and quantity chooser -->
									<ul class="more_qnty">
										<li>
											<div class="more_info">
												<a ng-href="${contextRoot}/show/{{product.id}}/product">More</a>
											</div>
										</li>
										<li>Price: &#163;{{product.price}}</li>
									</ul>
									<!-- Add item to the basket -->
								</div>
								<div class="button btn_add_item">
									<a ng-href="${contextRoot}/cart/add/{{product.id}}/product">Add to Basket</a>
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
						<img src="${imgProducts}/{{product.code}}.jpg" alt="{{product.name}}">
						<p class="product_name">{{product.name}}</p>
						<div class="frame_menu">
						
							<div class="row">
								
								<!-- Information about fruit country and fruit price -->
								<div class="col-6">
									<ul class="country_price">
										<li class="country_name">{{product.variety}}</li>
										<li>{{product.country}}</li>
									</ul>
								</div>
								<div class="col-6">
									<!-- Link to page about one fruit and quantity chooser -->
									<ul class="more_qnty">
										<li>
											<div class="more_info">
												<a ng-href="${contextRoot}/show/{{product.id}}/product">More</a>
											</div>
										</li>
										<li>Price: &#163;{{product.price}}</li>
									</ul>
									<!-- Add item to the basket -->
								</div>
								<div class="button btn_add_item">
									<a ng-href="${contextRoot}/cart/add/{{product.id}}/product">Add to Basket</a>
								</div>
							</div>

						</div>
					</div><!-- End of frame -->
					
				</div>
				
			</div><!-- End Col-4 -->
			
		</div>

	</div>
</section>
</div>