package com.example.ch01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PoemServlet", value = "/PoemServlet")
public class PoemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
//        String h = request.getHeader("user-agent");
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("poem", name);
        session.setAttribute("username", username);
        request.getRequestDispatcher("/out1.jsp").forward(request, response);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(username);
//        if(h.contains("Chrome")) out.println("您使用的是Chrome浏览器");
//        if(h.contains("Edge")) out.println("您使用的是Edge浏览器");
//        if(h.contains("FireFox")) out.println("您使用的是FireFox浏览器");
        if (name.equals("劝学")) out.println("<h3>《劝学》唐-孟郊 击石乃有火，不击元无烟。人学始知道，不学非自然。万事\n" +
                "须己运，他得非我贤。青春须早为，岂能长少年。 《劝学》唐-颜真卿 三更灯火五更鸡，正\n" +
                "是男儿读书时。黑发不知勤学早，白首方悔读书迟。</h3>");
        else out.println("<h3>抱歉暂未收录</h3>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
