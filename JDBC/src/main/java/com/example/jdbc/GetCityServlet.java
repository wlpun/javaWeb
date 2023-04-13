package com.example.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetCityServlet", value = "/GetCityServlet")
public class GetCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String countryCode = (String) request.getParameter("countryCode");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select id, name, District, Population from city where CountryCode = '%s'";
        sql = String.format(sql, countryCode);
        List<City> cityList = template.query(sql, new BeanPropertyRowMapper<>(City.class));
        HttpSession session = request.getSession();
        session.setAttribute("cityList", cityList);
        response.sendRedirect(request.getContextPath() + "/cityList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
