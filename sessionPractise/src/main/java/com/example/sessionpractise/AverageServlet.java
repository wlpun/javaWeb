package com.example.sessionpractise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AverageServlet", value = "/AverageServlet")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //代码逻辑参考TotalServlet
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ArrayList<Student> stuList = (ArrayList<Student>) session.getAttribute("stuList");
        int size = stuList.size();
        int sum = (int)request.getAttribute("total");
        double avg;
        if(size > 0) {
            avg = (sum * 1.0) / size;
            request.setAttribute("avg", (int)avg);
            response.sendRedirect(request.getContextPath() + "/energyAverage.jsp");
        }
        else {
            request.setAttribute("msg", "系统未初始化");
            response.sendRedirect(request.getContextPath() + "/energyMessage.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
