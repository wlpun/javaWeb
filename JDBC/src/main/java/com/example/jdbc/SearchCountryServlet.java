package com.example.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchCountryServlet", value = "/SearchCountryServlet")
public class SearchCountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select code, name, surfaceArea, population from country where name like concat('%',?,'%')";
        List<Country> countryList = template.query(sql, new BeanPropertyRowMapper<>(Country.class), name);
        HttpSession session = request.getSession();
        session.setAttribute("countryList", countryList);
        response.sendRedirect(request.getContextPath() + "/countryList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
