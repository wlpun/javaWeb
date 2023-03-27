package com.example.sessionpractise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "InitServlet", value = "/InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个学生列表对象  ArrayList<Student> studentList

        //2.循环创建50个学生，每次创建一个学生对象，就放入学生列表对象
        //        学号生成规则

        // 计科201 学号从 20145101开始 20145150结束
        // 计科202 学号从 20145201开始 20145250结束
        // 计科203 学号从 20145301开始 20145350结束
        //        能量生成规则，100以内随机正整数

        //3.学生列表对象 放入Session，属性名称为stuList

        //4.在request对象中写入msg属性，属性值为"系统初始化完成"

        //5.请求转发到 energyMessage.jsp页面,该页面中需要写jsp代码显示msg信息

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
