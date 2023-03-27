package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DonateServlet", value = "/DonateServlet")
public class DonateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String bloodtype = request.getParameter("bloodtype");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>无偿献血是无私奉献、救死扶伤的崇高行为。</h3>");
        out.println("<p>感谢您！" + bloodtype + "型血的" + name + "朋友。</p>");
//        out.println(request.getContextPath());
//        out.println(request.getServletPath());
//        out.println(request.getQueryString()+";;");
//        out.println(request.getRequestURI()+";;");
//        out.println(request.getRequestURL()+";;");
//        out.println(request.getProtocol()+";;");
//        out.println(request.getRemoteAddr()+";;");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}