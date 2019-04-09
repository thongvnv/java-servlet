package controller;

import entity.Feedback;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackModel feedbackModel = new FeedbackModel();
        ArrayList<Feedback> feedbacks = feedbackModel.getListFeedback();
        req.setAttribute("feedbacks", feedbacks);
        req.getRequestDispatcher("feedback.jsp").forward(req, resp);
    }
}
