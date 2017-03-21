<div class="nav col-2">
    <div class="logo">
        <a href="/"><img src="/images/gw2-auxiliary-logo.png"></a>
    </div>
<%if (session.getAttribute("user") == null) { %>

    <div class="login-links">
        <a href="/login">Log In</a>
        <a href="#">Create Account</a>
        <%@include file="searchBar.jsp"%>
    </div>

<% } else { %>

    <div class="user-links">
        <h2>Hello, ${user.getEmail()}!</h2>
        <%@include file="searchBar.jsp"%>
        <a href="/itemTracker.jsp">Item Tracker</a>
    </div>

<% } %>
</div>
