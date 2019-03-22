var app = angular.module('ShoppingApp', []);

app.controller('ProductController', function($http) {
	
	var me = this;
	
	me.europeProducts = [];
	me.asiaProducts = [];
	me.saProducts = [];
	
	me.fetchEuropeProducts = function() {
		
		$http.get('/supermarket/json/data/europe/mv/products')
			.then(function(response) {
				me.europeProducts = response.data;
			});
			
	}
	
	me.fetchAsiaProducts = function() {

		$http.get('/supermarket/json/data/asia/mv/products')
			.then(function(response) {
				me.asiaProducts = response.data;
		});

	}

	me.fetchSAProducts = function() {

		$http.get('/supermarket/json/data/sa/mv/products')
			.then(function(response) {
				me.saProducts = response.data;
		});

	}
	
});