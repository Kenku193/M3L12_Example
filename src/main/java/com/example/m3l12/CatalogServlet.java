package com.example.m3l12;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("counter");

        if (counter == null){
            session.setAttribute("counter", 1);
            counter = 1;
        }
        else {
            session.setAttribute("counter", counter + 1);
        }

        writer.println("<html><body>");
        writer.println("<h1>КАТАЛОГ</h1><br>");
        writer.println("<h2>Your counter is: " + counter + "</h2>");
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
