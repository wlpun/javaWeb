package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SetCookie1Servlet", value = "/SetCookie1Servlet")
public class SetCookie1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name1 = request.getParameter("name");
        String pwd1 = request.getParameter("pwd");
        String flag = request.getParameter("remember");
        if (flag.equals("true")) {
            Cookie name = new Cookie("name", name1);
            Cookie pwd = new Cookie("pwd", pwd1);
            response.addCookie(name);
            response.addCookie(pwd);
        }
        if (name1.equals("admin") && pwd1.equals("pwd")) {
            request.getRequestDispatcher("/indexCookie.jsp").forward(request,response);
        }
        else request.getRequestDispatcher("/loginCookie.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
