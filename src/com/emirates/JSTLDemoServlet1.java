package com.emirates;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//just to show the concept of JSTL.
@WebServlet("/jstl-demo")
public class JSTLDemoServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stud = new Student("raghav", 22);
        Student []studs = new Student[3];
        studs[0] = new Student("gunjan", 24);
        studs[1] = new Student("mohit", 20);
        studs[2] = new Student("didu", 33);

        req.setAttribute("student", stud);
        req.setAttribute("students", studs);

        RequestDispatcher rd = req.getRequestDispatcher("jstlDemo.jsp");
        rd.forward(req, resp);
    }
}
