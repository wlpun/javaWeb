package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OlympicServlet", value = "/OlympicServlet")
public class OlympicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int num1 = Integer.valueOf(request.getParameter("gold"));
        int num2 = Integer.valueOf(request.getParameter("silver"));
        int num3 = Integer.valueOf(request.getParameter("bronze"));
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.printf("<h3>2022 年北京冬奥会上中国队获得%d块奖牌！</h3>\n", num1 + num2 + num3);
        out.println("<img src='images/Olympic.png' alt='奖牌榜'>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
