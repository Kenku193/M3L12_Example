package com.example.m3l12;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "AuthServlet", value = "/AuthServlet")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("imya");
        String password = request.getParameter("password");

        Map<String, String[]> parameterMap = request.getParameterMap();

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<h1>АУТЕНТИФИКАЦИЯ</h1><br>");

        writer.println("<h2>Login: " + login + "</h2>");
        writer.println("<h2>Password: " + password + "</h2>");
        writer.println("<br>");


        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            writer.println(string);
        }

        writer.println("<br>");

        for (String[] value : parameterMap.values()) {
            for (String s : value) {
                writer.println(s);
            }
        }

        writer.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
