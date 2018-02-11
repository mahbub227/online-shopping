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
				<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST">
				
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
								</div>
								</div>
				
				<div class="form-group">
				<div class="col-md-offset-4 col-md-8">
				<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
				
				<sf:hidden path="productId"/>
				<sf:hidden path="views"/>
				<sf:hidden path="active"/>
				<sf:hidden path="image"/>
				</div>
				</div>
				
				
				
				</sf:form>
				</div>

				
	
	
	</div>

</div>
</div>
</div>
