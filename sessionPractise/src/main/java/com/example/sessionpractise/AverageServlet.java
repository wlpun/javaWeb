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
        Object flag = session.getAttribute("stulist");
        ArrayList<Student> stuList = new ArrayList<Student>();
        int size = 0;
        if(flag != null) {
            stuList = (ArrayList<Student>) flag;
            size = stuList.size();
        }
        int sum = (int) session.getAttribute("total");
        double avg;
        if(size > 0) {
            avg = (sum * 1.0) / size;
            request.setAttribute("avg", (int)avg);
            request.getRequestDispatcher("/energyAverage.jsp").forward(request,response);
        }
        else {
            request.setAttribute("msg", "系统未初始化");
            request.getRequestDispatcher("/energyMessage.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
