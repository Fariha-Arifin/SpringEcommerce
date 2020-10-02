<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/templete/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Admin Login</h1>

            <p class="lead">Admin must have tologin here</p>
            
        </div>
        
        <c:if test="${not empty msg }">
              <div class="msg" style="color:#ff0000;">${msg}</div>
         </c:if>
        
        <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="POST" >
            <c:if test="${not empty error }">
              <div class="error" style="color:#ff0000;">${error}</div>
            </c:if>
        
        <div class="form-group">
            <label for="name">User Name</label>
            <input type="text" id="username" name="username" class="form-control">
           
        </div>

        
        <div class="form-group">
            <label for="name">Password</label>
            <input type="password" id="password" name="password" class="form-control">
        </div>

        
        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        
        </form>
        
        
<%@include file="/WEB-INF/view/templete/footer.jsp" %>
        