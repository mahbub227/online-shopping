$(function(){
	switch(menu){
	case 'Home': $('#home').addClass('active');
	break;
	case 'About Us': $('#about').addClass('active');
	break;
	case 'Contact': $('#contact').addClass('active');
	break;
	case 'All Products' : $('#listProducts').addClass('active');
	break;
	default: $('#listProducts').addClass('active');
			 $('#a_'+menu).addClass('active');
			 break;
	}
	

		
		
		var products = [
			['1','abc'],
			['2','bcd'],
			['3','cda'],
			['4','dlo']
		];
		var $table = $('#productListTables');
		
		
		
		
		if($table.length){
			console.log('This is in table!');
			$table.DataTable({
				data: products
			});
		}
}
)