<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Feedback" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Feedback feedback = (Feedback) request.getAttribute("feedback");
    if (feedback == null) {
        feedback = new Feedback();
    }
%>

<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Gửi phản hồi"></jsp:param>
</jsp:include>
<body>
<jsp:include page="fragment/header.jsp"></jsp:include>
<div class="row text-center justify-content-center">
    <form class="col-3" action="/sendfeedback" method="post">
        <h2 class="mb-4 font-weight-normal">Feedback</h2>
        <div class="mb-3">
            <% if (errors.containsKey("title")) {
                ArrayList<String> titleErrors = errors.get("title");
                for (String titleError :
                        titleErrors) {
            %>
            <span class="text-danger"><%= titleError%></span><br>
            <%
                    }
                }
            %>
            <% if (errors.containsKey("content")) {
                ArrayList<String> contentErrors = errors.get("content");
                for (String contentError :
                        contentErrors) {
            %>
            <span class="text-danger"><%= contentError%></span><br>
            <%
                    }
                }
            %>
        </div>
        <input type="text" class="form-control mb-3" placeholder="Title" value="<%= feedback.getTitle() %>" name="title">
        <textarea class="form-control mb-3" rows="3" placeholder="Content" name="content"><%= feedback.getContent() %></textarea>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button>
    </form>
</div>
</body>
</html>
