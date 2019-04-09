package controller;

import entity.Feedback;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SendFeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sendfeedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");

        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setTitle(req.getParameter("title"));
        feedback.setContent(req.getParameter("content"));

        if (!feedback.isValid()) {
            req.setAttribute("feedback", feedback);
            req.setAttribute("errors", feedback.getErrors());
            req.getRequestDispatcher("sendfeedback.jsp").forward(req, resp);
            return;
        }

        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.insert(feedback);
        resp.getWriter().println("Send feedback success!");
    }
}
