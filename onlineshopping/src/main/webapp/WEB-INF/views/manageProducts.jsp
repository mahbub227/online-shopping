<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">


	<div class="row">
	<c:if test="${not empty message}">
	<div class="col-xs-12">
	<div class="alert alert-success alert-dismissable">
	<button type="button" class="close" date-dismiss="alert">&times;</button>
	${message}
	</div> 
	
	</div>
	</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>
				
				<div class="panel panel-body">
				<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
				
				<div class="form-group">
				<label class="control-label col-md-4" for="productName">Product Name</label>
				<div class="col-md-8">
				<sf:input type="text" path="productName" id="productName" placeholder="Product Name" class="form-control"/>
				<sf:errors path="productName" cssClass="help-block" element="em"/>
				</div>
				</div>
				
				<div class="form-group">
				<label class="control-label col-md-4" for="quantity">Quantity</label>
				<div class="col-md-8">
				<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity" class="form-control"/>
				</div>
				</div>
				
				<div class="form-group">
				<label class="control-label col-md-4" for="originalPrice">Original Price</label>
				<div class="col-md-8">
				<sf:input type="number" path="originalPrice" id="originalPrice" placeholder="Original Price" class="form-control" />
				</div>
				</div>
				
				<div class="form-group">
				<label class="control-label  col-md-4" for="discountPrice">Discount Price</label>
				<div class="col-md-8">
				<sf:input type="number" path="discountPrice" id="discountPrice" placeholder="Discount Price" class="form-control"/>
				</div>
				</div>
				
				<div class="form-group">
				<label class="control-label col-md-4" for="description">Description</label>
				<div class="col-md-8">
				<sf:textarea path="description" id="description" rows="4" placeholder="Description" class="form-control" />
					<sf:errors path="description" cssClass="help-block" element="em"/>
				</div>
				</div>
				
				<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" items="${categories}" itemLabel="categoryName" itemValue="categoryId" class="form-control"/>
								
								<c:if test="${product.productId==0}">
								<div class="text-right">
								<br/>
								<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">New Category</button>
								</div>
								</c:if>
								
								</div>
								</div>
								
								<div class="form-group">
				<label class="control-label col-md-4" for="file">Description</label>
				<div class="col-md-8">
				<sf:input type="file" path="file" id="file" class="form-control" />
				<sf:errors path="file" id="file" cssClass="help-block" elements="em"/>
				</div>
				</div>
				
				<div class="form-group">
				<div class="col-md-offset-4 col-md-8">
				<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
				
				<sf:hidden path="productId"/>
				<sf:hidden path="image"/>
				<sf:hidden path="views"/>
				<sf:hidden path="active"/>
				</div>
				</div>
				
				
				
				</sf:form>
				</div>

				
	
	
	</div>

</div>
</div>

<div class="row">
<div class="col-xs-12">
<h3>Available Products</h3>
<hr/>
</div>
<div class="col-xs-12">
<div style="overflow:auto">

<table id="adminProductsTable" class="table table-striped table-bordered">
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Image</th>
<th>Quantity</th>
<th>Original Price</th>
<th>Discount Price</th>
<th>Active</th>
<th>Edit</th>
</tr>
</thead>
<tbody>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>

</div>
</div>
</div>

<div class="row">
<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1" >
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">
<span>&times;</span>
</button>
<h4 class="modal-title">Add New Category</h4>
</div>
<div class="modal-body">

 <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
					<label class="control-label col-md-4">Category Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="categoryName" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
				
				
				<div class="form-group">
							<label class="control-label col-md-4">Parent ID</label>
							<div class="col-md-8">
								<sf:select path="parentId" items="${categories}" itemLabel="categoryName" itemValue="categoryId" class="form-control"/>
								
								</div>
								</div>
				
       			
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-primary"/>						
					</div>
				</div>	        
	        </sf:form>

</div>
</div>
</div>
</div>

</div>
</div>
