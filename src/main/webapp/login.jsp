<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
<%@include file="template/nav.jsp"%>
    <div class="content">

        <form action="j_security_check" method="POST">
            <table>
                <tr><td>Account Email: <INPUT TYPE="TEXT" NAME="j_username"></td></tr>
                <tr><td>Password: <INPUT TYPE="PASSWORD" NAME="j_password"></td></tr>
                <tr><td><INPUT TYPE="SUBMIT" VALUE="Log In"></td></tr>
            </table>
        </form>

    </div>
</body>
</html>