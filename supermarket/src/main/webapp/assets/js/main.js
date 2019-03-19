// function to open the side navigation
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
		case 'Basket':
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
		default:
			if(menu == "Home")
				break;
			$('#allProducts').addClass('active');
			$('#mobAllProducts').addClass('mob-active');
			$('#a_'+ menu).addClass('active');
	}
	
	//dismissing the alert after 3 seconds
	var $alert = $('.alert');

	if($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
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
									+ '<span class="fa fa-eye"></span></a>&nbsp;';
						
						str += '<a href="'
									+ window.contextRoot
									+ '/cart/add/'
									+ data
									+ '/product" class="btn btn-success">'
									+ '<span class="fa fa-shopping-cart"></span></a>';
						
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});
