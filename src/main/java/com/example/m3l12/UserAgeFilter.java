package com.example.m3l12;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "UserAgeFilter", servletNames = {"CatalogServlet", "FormServlet"})
public class UserAgeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
                + ", URL =" + req.getRequestURL());

        // Разрешить request продвигаться дальше. (Перейти данный Filter).
        chain.doFilter(request, response);

    }
}
