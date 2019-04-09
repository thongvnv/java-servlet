package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = checkLogin(username, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getId());
            session.setAttribute("role", user.getRole());
            resp.sendRedirect("/");
        } else {
            req.setAttribute("loginFail", "Login fail!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private User checkLogin(String username, String password) {
        User user = userModel.getUserByNameAndPassword(username, password);
        if (user != null) {
            return user;
        }
        return null;
    }
}
