<!DOCTYPE html>
<%@include file="head.jsp"%>
<body>
<%@include file="nav.jsp"%>
    <div class="content">

        <FORM ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
                <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
            </TABLE>
        </FORM>

    </div>
</body>
</html>