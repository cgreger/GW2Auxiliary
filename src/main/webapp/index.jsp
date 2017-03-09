<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
<%@include file="template/guestNav.jsp"%>
<div class="content">

    <table>
        <tr colspan="2"><th>User</th></tr>
        <tr><td>Id</td><td>${user.getId()}</td></tr>
        <tr><td>Email</td><td>${user.getEmail()}</td></tr>
    </table>

</div>
<%@include file="template/footer.jsp"%>
</body>
</html>