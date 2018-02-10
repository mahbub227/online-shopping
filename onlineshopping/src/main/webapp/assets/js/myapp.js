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
	case 'Manage Products': $('#manageProducts').addClass('active');
	break;
	default: $('#listProducts').addClass('active');
			 $('#a_'+menu).addClass('active');
			 break;
	}
	 

		var $table = $('#productListTable');
		
		if($table.length){
			//console.log('This is in table!');
			
			var jsonUrl='';
			if(window.categoryId==''){
				jsonUrl = window.contextRoot + '/json/data/all/products';
			}
			else{
				jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
			}
			
			$table.DataTable({
				lengthMenu: [[5,10,-1],['5 Records','10 Records','All']],
				pageLength: 5,
				ajax: {
					url: jsonUrl,
					dataSrc: ''
				},
				columns:[
					{
						data : 'image',
						bSortable : false,
						mRender : function(data, type, row) {

							return '<img src="' + window.contextRoot
									+ '/resources/images/' + data
									+ '" class="dataTableImg"/>';

						}
					},
					{
						data: 'productName'
					},
					{
						data: 'originalPrice',
							mRender: function(data, type, row){
								return '&#2547; '+data
							}
					},
					{
						data: 'discountPrice',
						mRender: function(data, type, row){
							return '&#2547; '+data
						}
					},
					{
						data: 'quantity',
						mRender: function(data, type, row){
							if(data<1){
								return '<span style="color:red">Out of Stock!</span>';
							}
							return data;
						}
					},
					{
						data: 'productId',
						bSortable: false,
						mRender: function(data, type, row){
							var str='';
							str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
							
							if(row.quantity<1){
								str+='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							else{
								str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
							
							
							return str;
						}
					},
				]
				
				
			});
		}
		
		var $alert = $('.alert');
		if($alert.length){
			setTimeout(function(){
				$alert.fadeOut('slow');
			},3000)
		}
}
)