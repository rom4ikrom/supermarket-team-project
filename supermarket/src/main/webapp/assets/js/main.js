// function to open the side navigation
function openNav() {
  document.getElementById("mySidenav").style.width = "200px";
}
//function to close side navigation
function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}


$(function() {
	
	
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
