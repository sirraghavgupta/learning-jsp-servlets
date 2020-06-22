package com.emirates;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("i am the add user servlet");
        PrintWriter out = resp.getWriter();
        out.println("i am the add user servlet");
        out.println(req.getParameter("name").toString());
        out.println(Integer.parseInt(req.getParameter("age")));
    }
}
