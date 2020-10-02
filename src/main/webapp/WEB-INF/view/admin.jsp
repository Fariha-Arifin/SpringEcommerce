
<%@include file="/WEB-INF/view/templete/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>

        <h3>
            <a href="<c:url value="/admin/productInventory" />" >Product Inventory</a>
        </h3>
        
        <h2>
           <a href="<c:url value="/login?logout" />">Logout</a>
        
        </h2>

        <p>Here you can view, check and modify the product inventory!</p>


        <%@include file="/WEB-INF/view/templete/footer.jsp" %>

