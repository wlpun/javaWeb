package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int num1 = Integer.valueOf(request.getParameter("gold"));
        int num2 = Integer.valueOf(request.getParameter("silver"));
        int num3 = Integer.valueOf(request.getParameter("bronze"));
        request.setAttribute("sum", num1 + num2 + num3);
        request.getRequestDispatcher("/OlympicServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
