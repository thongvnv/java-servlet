package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        if (!user.isValid()) {
            req.setAttribute("user", user);
            req.setAttribute("errors", user.getErrors());
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        UserModel userModel = new UserModel();
        userModel.insert(user);
        resp.getWriter().println("Submit thành công.");
    }
}
