// function to open the side navigation
function openNav() {
  document.getElementById("mySidenav").style.width = "200px";
}
//function to close side navigation
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}


$(function() {
	
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
		
		jsonUrl = window.contextRoot + '/json/data/all/products';
		
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
					data: 'unitPrice',
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
