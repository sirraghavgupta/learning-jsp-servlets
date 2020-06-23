package com.emirates;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * here i have applied the auth filter to protect some routes. so if someone wants to access the routes
 * without logging in, they wont be able to do that.
 */

@WebFilter(urlPatterns = {"/welcome", "/welcome.jsp", "/logout", "/videos"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        if(username == null){
            out.println("access denied");
        }
        else{
            // for HTTP 1.1
            ((HttpServletResponse) servletResponse).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            // for HTTP 1.0
            ((HttpServletResponse) servletResponse).setHeader("Pragma", "no-cache");
            // for proxy servers
            ((HttpServletResponse) servletResponse).setHeader("Expires", "0");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
