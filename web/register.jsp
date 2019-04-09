<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.User" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    User user = (User) request.getAttribute("user");
    if (user == null) {
        user = new User();
    }
%>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Đăng ký"></jsp:param>
</jsp:include>
<body>
    <jsp:include page="fragment/header.jsp"></jsp:include>
    <div class="row text-center justify-content-center">
        <form class="col-3" action="/register" method="post">
            <h2 class="mb-4 font-weight-normal">Register</h2>
            <div class="mb-3">
                <% if (errors.containsKey("username")) {
                    ArrayList<String> userNameError = errors.get("username");
                    for (String userError :
                            userNameError) {
                %>
                <span class="text-danger"><%= userError%></span><br>
                <%
                        }
                    }
                %>
                <% if (errors.containsKey("password")) {
                    ArrayList<String> passwordError = errors.get("password");
                    for (String passError :
                            passwordError) {
                %>
                <span class="text-danger"><%= passError%></span><br>
                <%
                        }
                    }
                %>
            </div>
            <input type="text" class="form-control mb-3" placeholder="Username" value="<%= user.getUsername() %>" name="username">
            <input type="password" class="form-control mb-4" placeholder="Password" name="password">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
        </form>
    </div>
</body>
</html>
