<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loginFail = (String) request.getAttribute("loginFail");
%>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Đăng nhập"></jsp:param>
</jsp:include>
<body>
    <jsp:include page="fragment/header.jsp"></jsp:include>
    <div class="row text-center justify-content-center">
        <form class="col-3" action="/login" method="post">
            <h2 class="mb-4 font-weight-normal">Login</h2>
            <div class="mb-3">
                <% if (loginFail != null) {%>
                <span class="text-danger">Login fail!</span>
                <%}%>
            </div>
            <input type="text" class="form-control mb-3" placeholder="Username" name="username">
            <input type="password" class="form-control mb-4" placeholder="Password" name="password">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
    </div>
</body>
</html>
