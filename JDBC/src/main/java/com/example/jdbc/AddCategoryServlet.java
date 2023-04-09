package com.example.jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "AddCategoryServlet", value = "/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取参数 category_name
        String category_name = request.getParameter("category_name");
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Pet> petList = null;
        //1. 加载并注册数据库驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //2．获取数据库连接
            conn= DriverManager.getConnection("jdbc:mysql://121.192.20.167:3306/petstore","21141132","21141132");
            //3．创建 Statement 对象，准备 SQL 语句
            stmt = conn.prepareStatement("insert into category(name) values(?)" );
            stmt.setString(1,category_name);
            //4．使用 Statement 对象执行 SQL 语句
            stmt.executeUpdate();
            //5．处理 ResultSet 结果集,增加修改删除操作无返回结果集
            //6．关闭连接，释放资源
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //重定向至 GetCategoryServlet，获取并展示全部宠物分类信息
        response.sendRedirect(request.getContextPath() + "/GetCategoryServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
