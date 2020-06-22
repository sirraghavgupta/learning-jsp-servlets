package com.emirates;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// implement the filter interface.
@WebFilter("/add-user")
public class AddUserAgeFilter implements Filter {

//    every filter has its own config also.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    // here, we can create an object we require or do some initialization task.
    }

    @Override
    public void destroy() {
    // clear the resources before destroying the filter or any other task.
    }

    /**
     * gets ServletRequest instead of HttpServletRequest.
     * gets a filter chain also.
     * filterChain.doFilter() calls the next filter and if its the last filter in the chain, then servlet
     * will be called.
     * filters are independent of each other and they dont know about each other.
     * the order of filters in the chain in automatically determined.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        PrintWriter out = resp.getWriter();

        System.out.println("i am the servlet age filter.");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println(age);

        if(age > 18)
            filterChain.doFilter(servletRequest, servletResponse);
        else
            out.append("invalid age - less than 18.");
    }
}
