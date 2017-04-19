<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
<%@include file="template/nav.jsp"%>
<div class="content">

    <table>
        <th>${item.getName()}</th>
        <c:forEach var="recipe" items="${item.getRecipes()}">
            <tr><td>${recipe.toString()}</td></tr>

        </c:forEach>
    </table>


</div>
<%@include file="template/footer.jsp"%>
</body>
</html>