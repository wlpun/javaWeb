package com.example.jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "GetPetServlet", value = "/GetPetServlet")
public class GetPetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取参数 category_id
        String category_id = request.getParameter("category_id");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Pet> petList = null;
        //1. 加载并注册数据库驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //2．获取数据库连接
            conn= DriverManager.getConnection("jdbc:mysql://121.192.20.167:3306/petstore?characterEncoding=utf-8","21141132","21141132");
            //3．创建 Statement 对象，准备 SQL 语句
            stmt = conn.prepareStatement("select * from pets where category_id = ?");
            //设置 sql 语句中第 1 个 ? 所在位置的参数值
            stmt.setString(1,category_id);
            //4．使用 PreparedStatement 对象执行 SQL 语句
            rs = stmt.executeQuery();
            //5．处理 ResultSet 结果集
            // 将结果数据封装为 Pet 对象，加入到
            petList = new ArrayList<Pet>();
            while(rs.next()){
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setTitle(rs.getString("title"));
                pet.setTag(rs.getString("tag"));
                pet.setPhoto(rs.getString("photo"));
                pet.setPrice(rs.getDouble("price"));
                pet.setStock(rs.getInt("stock"));
                pet.setDescs(rs.getString("descs"));
                petList.add(pet);
            }
            //6．关闭连接，释放资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        //宠物对象列表写入 Session 域，JSP 页面通过 EL 表达式读取并展示
        session.setAttribute("petList", petList);
        response.sendRedirect(request.getContextPath()+ "/petList.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
