package com.emirates;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// this is the annotation way to configure the servlets instead of doing it in xml.
// we can use a combination of both these approaches.
// servlet context can not be specified using the annotations.
@WebServlet(name = "MyServlet", urlPatterns = "/my", initParams = {
        @WebInitParam(name="name", value = "Raghav-MyServlet"),
})
//@WebServlet("/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter dom = resp.getWriter();
        dom.println("i am the MyServlet.");

        // here we see that servlet context is same for all servlets and how to access it.
        // getServletContext() is available in the HttpServlet class.
        ServletContext servletContext = getServletContext();

//        ServletContext servletContext = req.getServletContext();    // another way to get the object.
        String name = servletContext.getInitParameter("name");
        String phone = servletContext.getInitParameter("phone");

        dom.println(name + " " + phone);

        ServletConfig servletConfig = getServletConfig();
        String cName = servletConfig.getInitParameter("name");
        dom.println("name from servlet config - " + cName);

        /**
         * context and config are used to store some common information.
         * context is common for all the servlets while config is specific to one.
         * we can get these objects from the methods of the HttpServlet interface.
         * there are multiple ways to get them.
         * Object of ServletContext will be created at the time of web application deployment
         * Object of ServletConfig will be created during initialization process of the servlet
         */
    }
}
