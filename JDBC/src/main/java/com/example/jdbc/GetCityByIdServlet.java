package com.example.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetCityByIdServlet", value = "/GetCityByIdServlet")
public class GetCityByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.valueOf(request.getParameter("id")) ;
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select id, name, District, Population from city where id = ?";
        List<City> cityList = template.query(sql, new BeanPropertyRowMapper<>(City.class), id);
        City city = cityList.get(0);
        HttpSession session = request.getSession();
        session.setAttribute("city",city);
        response.sendRedirect(request.getContextPath() + "/editCity.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
