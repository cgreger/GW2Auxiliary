<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
<%@include file="template/nav.jsp"%>
    <div class="content">

        <FORM ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <TR><TD>Account Email: <INPUT TYPE="TEXT" NAME="j_username">
                <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
            </TABLE>
        </FORM>

    </div>
</body>
</html>