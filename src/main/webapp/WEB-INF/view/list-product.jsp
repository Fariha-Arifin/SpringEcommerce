<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/templete/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
        
	         <h1>All Products</h1>
	         
	         <p class="lead">Checkout all the awesome product available now</p>
      
        </div>
        <table class="table table-striped table-hover">
		  <thead>
		    <tr class="bg-success">
		      <th>Photo Thumb</th>
		      <th>Product Name</th>
		      <th>Category</th>
		      <th>Condition</th>
		      <th>Price</th>
		      <th></th>
		    </tr>
		  </thead>
		 <c:forEach items="${products}" var="product">
		  <tr>
		      <td><img class="setImage" width="300px" height="300px" src="<spring:url value="/resources/images/${product.productId}.png" />" alt="image" /></td>
	          <td>${product.productName}</td>
	          <td>${product.productCategory}</td>
	          <td>${product.producCondition}</td>
	          <td>${product.productPrice} USD</td>
	          <td>
	             <a href="<spring:url value="/productList/viewProduct/${product.productId}" />">
	                <span class="glyphicon glyphicon-info-sign"></span>
	             </a>
	           </td>
	      
	      </tr>
		 </c:forEach> 
		</table>
      
      
      
<%@include file="/WEB-INF/view/templete/footer.jsp" %>
