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
		case 'About Us':
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
		case 'Admin Login':
			$('#signIn').addClass('active');
			$('#mobSignIn').addClass('mob-active');
			break;
		case 'Home':
			$('#home').addClass('active');
			$('#mobHome').addClass('mob-active');
			break;
		default:
			if(menu == "Home")
				break;
			$('#allProducts').addClass('active');
			$('#mobAllProducts').addClass('mob-active');
			$('#a_'+ menu).addClass('active');
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
				},
			]
		});
		
	}
	
});
