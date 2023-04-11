package com.example.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetPetServlet2", value = "/GetPetServlet2")
public class GetPetServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_id = request.getParameter("category_id");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from pets where category_id = ?";
        List<Pet> petList = template.query(sql, new BeanPropertyRowMapper<>(Pet.class), category_id);
        HttpSession session = request.getSession();
        session.setAttribute("petList", petList);
        response.sendRedirect(request.getContextPath() + "/petList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
