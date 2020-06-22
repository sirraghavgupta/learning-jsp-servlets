package com.emirates;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/add-user")
public class AddUserNameFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        PrintWriter out = resp.getWriter();

        System.out.println("i am the servlet name filter.");
        String name = req.getParameter("name").toString();
        System.out.println(name);

        if(name.length() > 3)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            out.append("invalid name");
    }
}
