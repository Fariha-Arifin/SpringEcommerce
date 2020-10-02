<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/templete/header.jsp" %>

    <div class="container-wrapper">
      <div class="container">
        <div class="page-header">
        
	         <h1>Product Details</h1>
	         
	         <p class="lead">Here is the details information of the products</p>
      
        </div>
        
        <div class="container">
            <div class="row">
            
               <div class="col-md-5">
               <img class="setImage" width="200px" height="200px" src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"/>
                 
               </div>
                <div class="col-md-5">
                  <h3>${product.productName}</h3>
                  <p>
                     <strong>Product Description</strong> : 
                  </p>
                  <p>
                     <strong>Manufacture</strong> : ${product.productManufacturer}
                  </p>
                  <p>
                     <strong>Category</strong> : ${product.productCategory}
                  </p>
                  <p>
                     <strong>Condition</strong> : ${product.producCondition}
                  </p>
                  <p>
                     <strong>Price</strong> : ${product.productPrice} USD
                  </p>
               
               </div>
			  
			</div>
        
        </div>
       
      
      
<%@include file="/WEB-INF/view/templete/footer.jsp" %>
