package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        if (name.equals("21141132") && pwd.equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            int num = new Random().nextInt(101);
            session.setAttribute("num", num);
            response.sendRedirect(request.getContextPath() + "/lucky.jsp");
        } else response.sendRedirect(request.getContextPath() + "/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
