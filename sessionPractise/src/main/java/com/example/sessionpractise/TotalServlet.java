package com.example.sessionpractise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TotalServlet", value = "/TotalServlet")
public class TotalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session对象
        HttpSession session = request.getSession();
        //2.根据在InitServlet中写入的属性名读取session中保存的对象，赋值给一个Object类型变量
        Object studentList = session.getAttribute("stulist");
        ArrayList<Student> stuList = new ArrayList<>();
        //3.判断变量是否为null，
            //是null    在request对象中写入msg属性，属性值为"系统未初始化"，请求转发到energyMessage.jsp页面
        request.setCharacterEncoding("utf8");
        if (studentList == null) {
            request.setAttribute("msg", "系统未初始化");
            request.getRequestDispatcher("/energyMessage.jsp").forward(request,response);
        }
            //不是null  将变量强制类型转换为 ArrayList<Student> ,复制给变量 stuList
        else stuList = (ArrayList<Student>) studentList;
        //4.通过 stuList 变量，计算班级总能量数，结果写入request对象total属性，请求转发到energyTotal.jsp页面
        int sumEnergy = 0;
        for(Student stu: stuList) {
            sumEnergy += stu.getEnergy();
        }
        request.setAttribute("total", sumEnergy);
        session.setAttribute("total", sumEnergy);
        request.getRequestDispatcher("/energyTotal.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
