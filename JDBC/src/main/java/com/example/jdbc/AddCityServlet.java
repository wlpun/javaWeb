package com.example.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddCityServlet", value = "/AddCityServlet")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cityName = request.getParameter("cityName");
        String countryCode = request.getParameter("countryCode");
        String districtName = request.getParameter("districtName");
        String population = request.getParameter("population");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into city(Name, CountryCode, District, Population) values('%s', '%s', '%s', '%s')";
        sql = String.format(sql, cityName, countryCode, districtName, population);
        template.batchUpdate(sql);
        sql = "select name, CountryCode, District, Population from city where CountryCode = '%s'";
        sql = String.format(sql, countryCode);
        List<City> cityList = template.query(sql, new BeanPropertyRowMapper<>(City.class));
        HttpSession session = request.getSession();
        session.setAttribute("cityList", cityList);
        response.sendRedirect(request.getContextPath() + "/cityList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
