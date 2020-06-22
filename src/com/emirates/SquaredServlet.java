package com.emirates;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

// this is the annotation way to configure the servlets instead of doing it in xml.
// we can use a combination of both these approaches.
// servlet context can not be specified using the annotations.
@WebServlet(name = "SquaredServlet", urlPatterns = "/squared", initParams = {
        @WebInitParam(name="name", value = "Raghav-SquaredServlet"),
})
//@WebServlet("/my")
public class SquaredServlet extends HttpServlet {

// LEVEL 1,2,3 ===========================
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int val = (int)req.getAttribute("val");
//        PrintWriter dom = resp.getWriter();
//        dom.println("i am the squared servlet. result = " + val*val);
//    }

// LEVEL 4 =========================== SESSION ====
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        /*
//        * the session object is made universally available by the TOMCAT server. we can get and set the
//        * attributes and they will be available everywhere. we can also remove the attributes from the
//        * session.*/
//        HttpSession session = req.getSession();
////        session.removeAttribute("val");
//        int val = (int)session.getAttribute("val");
//        PrintWriter dom = resp.getWriter();
//        dom.println("i am the squared servlet. result = " + val*val);
//    }

    /*
    * NOTE -
    * getAttribute() always returns an object.
    * getParameter() always returns a string*/


    // LEVEL 5 =========================== COOKIE ====
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer val=null;
//
//        for(Cookie c : req.getCookies()){
//            if(c.getName().equals("val"))
//                val = Integer.parseInt(c.getValue());
//        }
//
//        PrintWriter dom = resp.getWriter();
//        dom.println("i am the squared servlet. result = " + val*val);
//    }

    // LEVEL 6 =========================== SERVLET REQUEST ====
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer val=null;

        for(Cookie c : req.getCookies()){
            if(c.getName().equals("val"))
                val = Integer.parseInt(c.getValue());
        }

        PrintWriter dom = resp.getWriter();
        dom.println("i am the squared servlet. result = " + val*val);

        // here we see that servlet context is same for all servlets and how to access it.
        ServletContext servletContext = getServletContext();
        String name = servletContext.getInitParameter("name");
        String phone = servletContext.getInitParameter("phone");

        dom.println(name + " " + phone);

        ServletConfig servletConfig = getServletConfig();
        String cName = servletConfig.getInitParameter("name");
        dom.println("name from servlet config - " + cName);
    }*/

    // LEVEL 7
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer val=null;
        for(Cookie c : req.getCookies()){
            if(c.getName().equals("val"))
                val = Integer.parseInt(c.getValue());
        }
        PrintWriter dom = resp.getWriter();

        // here its very difficult to write html, so we need jsp. there we write java into html.
        dom.println("<html>");
        dom.println("<body bgcolor='cyan'>");
        dom.println("<h1>i am the squared servlet. result = " + val*val + "</h1>");
        dom.println("</body>");
        dom.println("</html>");

    }
}


