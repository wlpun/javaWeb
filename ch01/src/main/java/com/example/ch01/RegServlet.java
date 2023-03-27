package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegServlet", value = "/RegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String realName = request.getParameter("realName");
        String[] serve = request.getParameterValues("serveType");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.printf("<h3>用户名：%s</h3>\n", userName);
        out.printf("<h3>邮箱：%s</h3>\n", email);
        out.printf("<h3>真实姓名：%s</h3>\n", realName);
        out.println("<strong>serveType: </strong>");
        int t = 0;
        for (String s : serve) {
            if (t == 1) out.print(", ");
            out.printf("<strong>%s</strong>", s);
            t = 1;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
