package com.example.jdbc;

import com.mysql.cj.jdbc.Driver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "AddDepartmentServlet", value = "/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String num = request.getParameter("num");
        String name = request.getParameter("name");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Department> departmentArrayList = null;
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://121.192.20.167:3306/employees?characterEncoding=utf-8", "21141132", "21141132");
            statement = connection.createStatement();
            String sql = "INSERT INTO departments(dept_no, dept_name) VALUES('%s', '%s');";
            sql = String.format(sql, num, name);
            int count = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql1 = "select dept_no, dept_name from departments";
            resultSet = statement.executeQuery(sql1);
            departmentArrayList = new ArrayList<Department>();
            while (resultSet.next()) {
                Department department = new Department(resultSet.getString("dept_no"), resultSet.getString("dept_name"));
                departmentArrayList.add(department);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("departmentArrayList", departmentArrayList);
        response.sendRedirect(request.getContextPath() + "/departmentList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
