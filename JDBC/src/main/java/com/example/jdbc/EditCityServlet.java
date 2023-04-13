package com.example.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditCityServlet", value = "/EditCityServlet")
public class EditCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.valueOf(request.getParameter("id"));
        String cityName = request.getParameter("cityName");
        String districtName = request.getParameter("districtName");
        String population = request.getParameter("population");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update city set name = '%s', district = '%s', population = %s where id = %d";
        sql = String.format(sql, cityName, districtName, population, id);
        template.batchUpdate(sql);
        response.sendRedirect(request.getContextPath() + "/GetFranceCityServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
