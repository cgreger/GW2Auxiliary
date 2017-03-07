<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
${nav}
<div class="content">

    <table>
        <th>${user.getEmail()}</th>
    </table>

</div>
<%@include file="template/footer.jsp"%>
</body>
</html>