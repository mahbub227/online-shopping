<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 
      
     

<div class="nav-side-menu">
    <div class="brand">Brand Logo</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content">
            
            
          <c:forEach items="${categories}" var="parentCategory">
          
          <c:if test="${parentCategory.parentId==0}">
          
        <li  data-toggle="collapse" data-target="#${parentCategory.categoryName}" class="collapsed active">
                  <a href="#"><i class="fa fa-gift fa-lg"></i>${parentCategory.categoryName}<span class="arrow"></span></a>
                   
                     <ul class="sub-menu collapse" id="${parentCategory.categoryName}">
                   <c:forEach items="${categories}" var="category">
          
          <c:if test="${category.parentId==parentCategory.categoryId}">
              
                  <li class="active"> <a href="${contextRoot}/show/category/${category.categoryId}/products" id="a_${category.categoryName}">${category.categoryName}</a></li>
    
          
          </c:if>
          
          </c:forEach>
          
           </ul>
         </li>
          
          </c:if>
          
          </c:forEach>
            


             
     </div>
</div>