package org.itstep.Lesson_14.servlets;

import org.itstep.Lesson_14.db.DbManager;
import org.itstep.Lesson_14.db.Operations;
import org.itstep.Lesson_14.entities.Post;
import org.itstep.Lesson_14.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/addPost")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("USER_SESSION");

        if(user != null) {
            request.getRequestDispatcher("addPost.jsp").forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        User user = (User) request.getSession().getAttribute("USER_SESSION");

        String redirect = "/addPost?error";

        if(user != null) {

            Post post = new Post(title, content, user.getId(), null);
            if(DbManager.addOrUpdate(Operations.CREATE, post)) {
                redirect = "/addPost?success";
            }
        }

        response.sendRedirect(redirect);
    }
}
