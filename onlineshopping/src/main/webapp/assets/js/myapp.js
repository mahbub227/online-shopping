$(function() {
	switch (menu) {
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	var $table = $('#productListTable');

	if ($table.length) {
		// console.log('This is in table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 5, 10, -1 ],
							[ '5 Records', '10 Records', 'All' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'image',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg'
											+ '" class="dataTableImg"/>';

								}
							},
							{
								data : 'productName'
							},
							{
								data : 'originalPrice',
								mRender : function(data, type, row) {
									return '&#2547; ' + data
								}
							},
							{
								data : 'discountPrice',
								mRender : function(data, type, row) {
									return '&#2547; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'productId',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									}

									return str;
								}
							}, ]

				});
	}

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	var $adminProductsTable = $('#adminProductsTable');

	if ($adminProductsTable.length) {
		// console.log('This is in table!');

		var jsonUrl = '';
		jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					lengthMenu : [ [ 10, 25, -1 ],
							[ '10 Records', '25 Records', 'All' ] ],
					pageLength : 20,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'productId'
							},
							{
								data : 'productName'
							},
							{
								data : 'image',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg'
											+ '" class="adminTableImg"/>';

								}
							},
							{
								data : 'quantity',
							},
							{
								data : 'originalPrice',
								mRender : function(data, type, row) {
									return '&#2547; ' + data
								}
							},
							{
								data : 'discountPrice',
								mRender : function(data, type, row) {
									return '&#2547; ' + data
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									if (data) {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.productId
												+ '" checked="checked">  <div class="slider round"> </div></label>';

									} else {
										str += '<label class="switch"> <input type="checkbox" value="'
												+ row.productId
												+ '">  <div class="slider round"> </div></label>';
									}

									return str;
								}
							},
							{
								data : 'productId',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

									return str;
								}
							} ],
					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var dText = (this.checked) ? 'You want to activate the Product?'
													: 'You want to de-activate the Product?';
											var checked = this.checked;
											var checkbox = $(this);
											debugger;
											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation/Deactivation',
														message : dText,
														callback : function(
																confirmed) {
															if (confirmed) {
																$
																		.ajax({
																			type : 'GET',
																			url : window.contextRoot
																					+ '/manage/product/'
																					+ checkbox
																							.prop('value')
																					+ '/activation',
																			timeout : 100000,
																			success : function(
																					data) {
																				bootbox
																						.alert(data);
																			},
																			error : function(
																					e) {
																				bootbox
																						.alert('ERROR: '
																								+ e);
																				// display(e);
																			}
																		});
															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});

					}
				});
	}
	
	
	
	
	
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		$categoryForm.validate({
			rules : {
				categoryName: {
					required : true,
				},
		
			},
			message: {
				categoryName:{
					required: 'Enter a category Name!',
				}
			},
			errorElement : 'em',
			errorPlacement: function(error, element){
				error.addClass("help-block");
				error.insertAfter(element);
			}
		});
	}
	
	

})