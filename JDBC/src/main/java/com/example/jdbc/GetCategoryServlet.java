package com.example.jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "GetCategoryServlet", value = "/GetCategoryServlet")
public class GetCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Category> categoryList = null;
        //1. 加载并注册数据库驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //2．获取数据库连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/petstore","root","root");
            //3．创建 Statement 对象，准备 SQL 语句
            stmt = conn.createStatement();
            String sql = "select id,name from category";
            //4．使用 Statement 对象执行 SQL 语句
            rs = stmt.executeQuery(sql);
            //5．处理 ResultSet 结果集
            // 将结果数据封装为 Category 对象，加入到
            categoryList = new ArrayList<Category>();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categoryList.add(category);
            }
            //6．关闭连接，释放资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        //分类对象列表写入 Session 域，JSP 页面通过 EL 表达式读取并展示
        session.setAttribute("categoryList",categoryList);
        response.sendRedirect(request.getContextPath()+ "/categoryList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
