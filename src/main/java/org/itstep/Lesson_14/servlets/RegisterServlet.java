package org.itstep.Lesson_14.servlets;

import org.itstep.Lesson_14.db.DbManager;
import org.itstep.Lesson_14.db.Operations;
import org.itstep.Lesson_14.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String fullName = request.getParameter("full_name");

        String redirect = "/register?error=1&email="+email;

        User checkUser = DbManager.getUserByEmail(email);

        if(checkUser == null) {
            redirect = "/register?error=2";
            if(password.equals(confirmPassword)) {
                DbManager.addOrUpdate(Operations.CREATE,new User(email, password, fullName));
                redirect = "/register?success";
            }
        }

        response.sendRedirect(redirect);

    }
}
