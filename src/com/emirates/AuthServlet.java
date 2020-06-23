package com.emirates;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Authenticate", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    private AuthDao authDao;

    public AuthServlet() {
        authDao = new AuthDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(authDao.authenticate(username, password)){
            System.out.println("user signed in successfully");
            session.setAttribute("username", username);
            resp.sendRedirect("welcome");
        }
        else{
            System.out.println("login failed");
            session.setAttribute("username", null);
            resp.sendRedirect("login");
        }
    }
}
