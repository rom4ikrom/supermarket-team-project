//function to open the side navigation
function openNav() {
	document.getElementById("mySidenav").style.width = "200px";
}
//function to close side navigation
function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
}

$(function() {
	
	//active menu
	switch (menu) {
		case 'AboutUs':
			$('#aboutUs').addClass('active');
			$('#mobAboutUs').addClass('mob-active');
			break;
		case 'Catalog':
			$('#a_all').addClass('active');
			
			$('#allProducts').addClass('active');
			$('#mobAllProducts').addClass('mob-active');
			break;
		case 'UserCart':
			$('#basket').addClass('active');
			$('#mobBasket').addClass('mob-active');
			break;
		case 'Login':
			$('#signIn').addClass('active');
			$('#mobSignIn').addClass('mob-active');
			break;
		case 'AdminLogin':
			$('#signIn').addClass('active');
			$('#mobSignIn').addClass('mob-active');
			break;
		case 'Home':
			$('#home').addClass('active');
			$('#mobHome').addClass('mob-active');
			break;
		case 'ProductManagement':
			$('#manageProducts').addClass('active');
			$('#mobManageProducts').addClass('mob-active');
			break;
		case 'SupplyProducts':
			$('#supplyProducts').addClass('active');
			$('#mobSupplyProducts').addClass('mob-active');
			break;
		case 'AccountPersonal':
			$('#userName').addClass('active');
			$('#accPersonal').addClass('active');
			$('#mobAccount').addClass('mob-active');
			break;
		case 'AccountAddress':
			$('#userName').addClass('active');
			$('#accAddress').addClass('active');
			$('#mobAccount').addClass('mob-active');
			break;
		case 'AccountOrders':
			$('#userName').addClass('active');
			$('#accOrders').addClass('active');
			$('#mobAccount').addClass('mob-active');
			break;
		default:
			if(menu == "Home")
				break;
			$('#allProducts').addClass('active');
			$('#mobAllProducts').addClass('mob-active');
			$('#a_'+ menu).addClass('active');
	}
	
	if (!(window.menu == "Login")) {
		//to tackle the csrf token
		
		var token = $('meta[name="_csrf"]').attr('content');
		var header = $('meta[name="_csrf_header"]').attr('content');
		
		if(token.length > 0 && header.length > 0) {
			
			//set the token header for the ajax request
			$(document).ajaxSend(function(e, xhr, options) {
				
				xhr.setRequestHeader(header, token);
				
			});
			
		}
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');

	if($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	//validating the login form
	var $loginForm = $('#loginForm');

	if($loginForm.length) {

		$loginForm.validate( {

			rules : {
				username : {
					required: true,
					email: true
				}, 

				password : {
					required: true
				}
			},

			messages : {

				username : {
					required: 'Please enter the username!',
					email: 'Please enter valid email address!'
				},

				password : { 

					required: 'Please enter the password!'

				}

			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}

		});

	}
	
	//script for map on about us page
	var $googleMap = $('#map');
	
	if($googleMap.length) {
		var myCenter = new google.maps.LatLng(51.5074, 0.1278);
	    function initialize(){
	      var mapProp = {
	        center:myCenter,
	        zoom:12,
	        mapTypeId:google.maps.MapTypeId.ROADMAP
	      };
	      
	      var map = new google.maps.Map(document.getElementById("map"),mapProp);

	      var marker = new google.maps.Marker({
	        position:myCenter,
	      });

	      marker.setMap(map);
	    }
	    google.maps.event.addDomListener(window, 'load', initialize);
	}
	
	// code for jquery dataTable
	var $table = $('#productListTable');
	
	// execute the below code only when where we have this table
	
	if($table.length) {
		
		var jsonUrl = '';
		
		if(window.regionId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/region/'
						+ window.regionId + '/products';
		}

		$table.DataTable({
			
			lengthMenu: [
				[5, 10, 20, -1],
				['5 Records', '10 Records', '20 Records', 'All Records']
			],
			order: [[ 1, "asc" ]],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			
			columns: [
				{
					data: 'code',
					bSortable: false,
					mRender: function(data, type, row) {
						return '<img src="' + window.contextRoot + 
						'/resources/img/products/' + data + '.jpg" class="data-table-img"/>';
					}
				},
				{
					data: 'name',
				},
				{
					data: 'variety',
				},
				{
					data: 'country',
				},
				{
					data: 'price',
					mRender: function(data, type, row) {
						return '&#xA3;' + data
					}
				},
				{
					data: 'quantity',
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						
						var str = '';
						str += '<a href="'
									+ window.contextRoot
									+ '/show/'
									+ data
									+ '/product" class="btn btn-primary">'
									+ '<span class="fa fa-eye"></span></a>&#160;';
						
						if(userRole == 'ADMIN') {
							str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">'+
							'<span class="fa fa-pencil"></span></a>';
						} else {
							if(row.quantity < 1) {
								str += '<a href="javascritp:void(0)" class="btn btn-success disabled">'+
								'<span class="fa fa-shopping-cart"></span></a>';
							} else {
								str += '<a href="'
									+ window.contextRoot
									+ '/cart/add/'
									+ data
									+ '/product" class="btn btn-success">'
									+ '<span class="fa fa-shopping-cart"></span></a>';
							}
						}
						
						return str;
						
					}
				},
			]
		});
		
	}
	
	//------------------------------------------------------------
	
	//data table for admin
	var $adminProductsTable = $('#adminProductsTable');
	
	//execute the code below only when we have this table
	if($adminProductsTable.length) {
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		$adminProductsTable
		.DataTable({
			
			lengthMenu : [
				[10, 30, 50, -1],
				['10 Records', '30 Records', '50 Records', 'All Records']
			],
			
			pageLength: 30,
			
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			
			columns: [
				{
					data: 'id'
				},
				{
					data: 'code',
					mRender: function(data, type, row) {
						return '<img src="' + window.contextRoot + '/resources/img/products/' + data + '.jpg"' +
						'class="data-table-img"/>';
					}
				},
				{
					data: 'name',
				},
				{
					data: 'variety',
				},
				{
					data: 'country',
				},
				
				{
					data: 'price',
					mRender: function(data, type, row) {
						return '&#163;' + data;
					}
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if(data < 1) {
							return '<span style="color:red">Out of Stock</span>';
						}
						return data;
					}
				},
				{
					data: 'active',
					bSortable: false,
					mRender: function(data, type, row) {
						
						var str = '';
						str += '<label class="switch">';
						
						if(data) {
							str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
						} else {
							str += '<input type="checkbox" value="'+row.id+'"/>';
						}
						
						str += '<div class="slider"></div></label>';
						return str;
						
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						
						var str = '';
						str += '<a href="'+window.contextRoot+'/manage/'+data+'/product"' +
						'class="btn btn-warning">';
						str += '<span class="fa fa-pencil"></span>';
						
						return str;
						
					}
				}
			],
			initComplete: function() {
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', function() {
					
					var checkbox = $(this);
					
					var checked = checkbox.prop('checked');
					var dMsg = (checked)? 'You want to activate the product?':
						'You want to deactivate the product?';
					var value = checkbox.prop('value');
					
					bootbox.confirm({
						size: 'medium',
						title: 'Product Activation & Diactivation',
						message: dMsg,
						callback: function(confirmed) {
							
							if(confirmed) {
								
								var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation/';
								
								$.post(activationUrl, function(data) {
									bootbox.alert({
										size: 'medium',
										title: 'Information',
										message: data
									});
								});
								
							} else {
								checkbox.prop('checked', !checked);
							}
							
						}
					});
					
				});
			}
			
		});
		
	}
	
	
	//------------------------------------------------------------
	
	//handling the clikc event of refresh cart button
$('button[name="refreshCart"').click(function() {
		
		//fetch the cart line id
		var cartLineId = $(this).attr('value');
		
		var countElement = $('#count_' + cartLineId);
		
		var originalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		//work only when the count has changed
		if(currentCount !== originalCount) {
			
			if(currentCount < 1 || currentCount > 3) {
				//reverting back to the original count
				//user has given value below 1 and above 3
				countElement.val(originalCount);
				
				bootbox.alert({
					
					size: 'medium',
					title: 'Error',
					message: 'Product count should be min 1 and max 3!'
					
				});
				
			} else {
				
				var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
				
				//forward it to the controller
				
				window.location.href = updateUrl;
				
				
			}
			
		}
		
	});

	//------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
});
