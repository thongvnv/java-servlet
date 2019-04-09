<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Trang chủ"></jsp:param>
</jsp:include>
<body>
    <jsp:include page="fragment/header.jsp"></jsp:include>
    <div class="text-center">
        <a href="/login">Login</a>
        |
        <a href="/register">Register</a>
        |
        <a href="/sendfeedback">Send feedback</a>
        |
        <a href="/feedback">Feedback</a>
        |
        <a href="/admin">Admin</a>
    </div>
</body>
</html>
