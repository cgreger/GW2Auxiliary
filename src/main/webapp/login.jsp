<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
<%@include file="template/guestNav.jsp"%>
    <div class="content">

        <form action="j_security_check" method="POST">
            <table>
                <tr><td>Account Email: <input consumableType="TEXT" name="j_username"></td></tr>
                <tr><td>Password: <input consumableType="PASSWORD" name="j_password"></td></tr>
                <tr><td><input consumableType="SUBMIT" value="Log In"></td></tr>
            </table>
        </form>

    </div>
</body>
<%@include file="template/footer.jsp"%>
</html>