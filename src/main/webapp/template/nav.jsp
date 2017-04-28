<div class="nav col-2">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/images/gw2-auxiliary-logo.png"></a>
    </div>
<%if (session.getAttribute("user") == null) { %>

    <div class="login-links">
        <a href="${pageContext.request.contextPath}/login">Log In</a>
        <a href="${pageContext.request.contextPath}/create-account">Create Account</a>
        <%@include file="searchBar.jsp"%>
    </div>

<% } else { %>

    <div class="user-links">
        Hello, ${user.getEmail()}! | <a href="${pageContext.request.contextPath}/logout">Log Out</a>
        <%@include file="searchBar.jsp"%>
        <a href="${pageContext.request.contextPath}/itemTracker.jsp">Item Tracker</a>
        <%if (session.getAttribute("isAdmin").equals(true)) { %>
             | Admin |
            <!--TODO: make sure you can only hit this once-->
        <form action="${pageContext.request.contextPath}/update-item-database" method="post">
            <input type="submit" value="Update Item Database" />
        </form>




        <% } %>
    </div>

<% } %>
</div>
