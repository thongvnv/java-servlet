<%@ page import="entity.Feedback" %>
<%@ page import="java.util.ArrayList" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Feedback> feedbacks = (ArrayList<Feedback>) request.getAttribute("feedbacks");
    if (feedbacks == null) {
        feedbacks = new ArrayList<>();
    }
%>

<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Quản lý"></jsp:param>
</jsp:include>
<body>
<jsp:include page="fragment/header.jsp"></jsp:include>
<h1>Index</h1>
<ul>
    <%
        for (Feedback feedback :
                feedbacks) {
    %>
    <li><%= feedback.getTitle() %></li>
    <%}%>
</ul>
</body>
</html>