package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("test1.html");
//        response.sendRedirect("test2.html");
//        request.setAttribute("qw", 123);
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("qw", 123);
        response.sendRedirect(request.getContextPath() + "/ServletContextServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
