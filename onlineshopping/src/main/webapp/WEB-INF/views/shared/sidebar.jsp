<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 <h1 class="my-4">Shop Name</h1>
          <div class="list-group">
          
          <c:forEach items="${categories}" var="category">
          <a href="${contextRoot}/show/category/${category.categoryId}/products" class="list-group-item" id="a_${category.categoryName}">${category.categoryName}</a>
          </c:forEach>
          
          </div>