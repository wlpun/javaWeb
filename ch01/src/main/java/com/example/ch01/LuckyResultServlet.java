package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LuckyResultServlet", value = "/LuckyResultServlet")
public class LuckyResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int n = Integer.valueOf(request.getParameter("n"));
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (n == (int)request.getSession().getAttribute("num")) {
            response.sendRedirect(request.getContextPath() + "/inc.jsp");
        }
        else response.sendRedirect(request.getContextPath() + "/err.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
