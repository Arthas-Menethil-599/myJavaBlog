package org.itstep.Lesson_14.servlets;

import org.itstep.Lesson_14.db.DbManager;
import org.itstep.Lesson_14.entities.User;
import org.itstep.Lesson_14.models.Blog;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Blog> posts = DbManager.getAllPosts();
        request.setAttribute("posts", posts);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}