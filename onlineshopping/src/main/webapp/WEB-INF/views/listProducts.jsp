
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">

	<div class="row">

		<div class="col-sm-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<div class="col-sm-9">
			<div class="row">
				
				<div class="col-sm-12">
				<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.categoryName}</li>
						</ol>
					</c:if>

							</div>
							</div>
			<div class="row">
				<div class="col-sm-12">
				
				<table id="productListTables" class="table table-striped table-bordered">
				<tr>
				<th>ID</th>
				<th>Name</th>
				</tr>
				</table>
				</div>
				</div>
				
		</div>
	</div>
	</div>