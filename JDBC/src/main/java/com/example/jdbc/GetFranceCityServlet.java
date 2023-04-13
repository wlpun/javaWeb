package com.example.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFranceCityServlet", value = "/GetFranceCityServlet")
public class GetFranceCityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select id, name, District, Population from city where CountryCode in (select code from country where name = 'France')";
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
