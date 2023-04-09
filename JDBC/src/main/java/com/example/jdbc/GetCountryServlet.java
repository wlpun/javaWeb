package com.example.jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "GetCountryServlet", value = "/GetCountryServlet")
public class GetCountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String continent = request.getParameter("continent");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Country> countryArrayList = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://121.192.20.167:3306/world?characterEncoding=utf-8","21141132", "21141132");
            statement = connection.createStatement();
            String sql = "select code, name, surfaceArea, population from country where continent = '%s'";
            sql = String.format(sql, continent);
            resultSet = statement.executeQuery(sql);
            countryArrayList = new ArrayList<Country>();
            while(resultSet.next()) {
                Country country = new Country(resultSet.getString("code"), resultSet.getString("name"), resultSet.getString("surfaceArea"), resultSet.getString("population"));
                countryArrayList.add(country);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("countryArrayList", countryArrayList);
        response.sendRedirect(request.getContextPath() + "/countryList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
