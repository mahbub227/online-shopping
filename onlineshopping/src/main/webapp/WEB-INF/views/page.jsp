<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
    <!DOCTYPE html>
<html lang="en">

  <head>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>
    
     <script>
    window.menu='${title}';
    window.contextRoot='${contextRoot}';
    </script>
      <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">
    
    <!-- Bootstrap core CSS -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
     <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
     
     <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

  

  </head>

  <body>
  
  <div class="wrapper">

    <!-- Navigation -->
    <class="row">
    <%@ include file="./shared/navbar.jsp" %>
     

    <!-- Page Content -->
    <div class="content">
    
    <c:if test="${userClickHome==true}">
    <%@ include file="home.jsp" %>
    </c:if>
    
     <c:if test="${userClickAbout==true}">
    <%@ include file="about.jsp" %>
    </c:if>
    
     <c:if test="${userClickContact==true}">
    <%@ include file="contact.jsp" %>
    </c:if>
    
     <c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
    <%@ include file="listProducts.jsp" %>
    </c:if>
    </div>
    
      <c:if test="${userClickShowProduct==true}">
    <%@ include file="singleProduct.jsp" %>
    </c:if>
    
     <c:if test="${userClickManageProducts==true}">
    <%@ include file="manageProducts.jsp" %>
    </c:if>
    </div>
    
    <!-- /.container -->

    <!-- Footer -->
    <%@ include file="./shared/footer.jsp" %>
    
   
</div>
 <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/jquery.validate.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/dataTables.bootstrap.js"></script>
    <script src="${js}/bootbox.min.js"></script>
    <script src="${js}/myapp.js"></script>
  </body>

</html>
    