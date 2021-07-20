package org.itstep.Lesson_14.servlets;

import org.itstep.Lesson_14.db.DbManager;
import org.itstep.Lesson_14.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String redirect = "/login?email="+email+"&error=1";

        if(email != null && password != null) {
            User dbUser= DbManager.getUserByEmail(email);
            if(dbUser != null) {

                redirect = "/login?email="+email+"&error=2";
                if (dbUser.getPassword().equals(password)) {
                    redirect = "/";
                    HttpSession session = request.getSession();
                    session.setAttribute("USER_SESSION", dbUser);
                }
            }
        }
        response.sendRedirect(redirect);
    }
}
