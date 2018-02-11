<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">

<div class="row">
<div class="col-xs-12">
<ol class="breadcrumb">
<li><a href="${contextRoot}/home">Home</a></li>
<li><a href="${contextRoot}/show/all/products">Products</a></li>
<li class="active">${product.productName}</li>

</ol>
</div>
</div>

<div class="row">
<div class="col-sm-4 col-xs-12">
<div class="thumbnail">
<img src="${images}/${product.image}.jpg" class="img img-responsive"/>
</div>
</div>

<div class="col-xs-12 col-sm-8">

<h3>${product.productName}</h3>
<hr/>

<p>${product.description}</p>
<hr/>
<h4>Original Price: <strong>&#2547; ${product.originalPrice}</h4>

<p>${product.description}</p>
<hr/>
<h4>After Discount: <strong>&#2547; ${product.discountPrice}</h4>



<c:choose>
<c:when test="${product.quantity<1}">
<h6>Available: <span style="color:red">Out of Stock!</span></h6>
</c:when>

<c:otherwise>
<h6>Available: ${product.quantity}</h6>
</c:otherwise>
</c:choose>

<c:choose>
<c:when test="${product.quantity<1}">
<a href="javascript:void(0)" class="btn btn-danger disabled"><strike>
<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>
</c:when>

<c:otherwise>
<a href="${contextRoot}/cart/add/${product.productId}/product" class="btn btn-success">
<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
</c:otherwise>
</c:choose>


<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
</div>

</div>

</div>

</body>
</html>