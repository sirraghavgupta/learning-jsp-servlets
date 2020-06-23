package com.emirates;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

//    LEVEL 0 ===========================================
//    service method is always called first by the tomcat server. we can override that if we want.
//    else it has the default definition.
//    @Override
//    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        // this getWriter is used to modify the response object and it will be displayed on the dom.
//        PrintWriter dom = resp.getWriter();
//        dom.println(result);
//    }

//    LEVEL 1 =========================================
//    doGet() and doPost() run only for get and post request specifically. they are called internally by the
//    default definition of the service method.
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        PrintWriter dom = resp.getWriter();
//        dom.println(result);
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        PrintWriter dom = resp.getWriter();
//        dom.println(result);
//    }



    // LEVEL 2 =========================================
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        req.setAttribute("val", result);
//        // this is one way to call another servlet from one servlet.
//        // it doesnt change the url on the browser.
//        // we can easily pass the values if required, by the setAttribute() as we are forwarding the same request and response objects.
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/squared");
//        dispatcher.forward(req, resp);
//    }

/*
//    NOTE ===========
* the HttpServletRequest req, HttpServletResponse resp objects are actually provided by the tomcat.
* HttpServletRequest, HttpServletResponse are actually interfaces and the implementation is provided
  by the tomcat and it provides the object then.
 */

    /*
    * in the request dispatcher, we forward the request to another servlet and use the same req and resp
    * objects as in first servlet. in this, the browser is not aware of this req forwarding and doesnt get
    * to know that the response has come from another servlet because no redirection is there.
    * advantage is that - we can pass data from servlet 1 to servlet 2.
    * no url change is reflected.
    *
    * but, if i want to make it aware of this, then we use sendRedirect() .
    * it informs the browser to redirect itself to another route and it sends a new request again.
    * now, here i cant pass data between the 2 servlets. so we need to use
    *  1. session management
    *  2. cookies
    *  3. URL rewriting/ query params there.*/

//    LEVEL 3 =================================== [URL Rewriting]
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        // here we are rewriting the url and setting the query params.
//        resp.sendRedirect(req.getContextPath() + "/squared" + "?val=" + result);
//    }


    //    LEVEL 4 =================================== [SESSION management]
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//
//        /*
//         * the session object is made universally available by the TOMCAT server. we can get and set the
//         * attributes and it will be available everywhere. we can also remove the attributes from the
//         * session.
//         * HttpSession is an interface whose implementation is provided by the TOMCAT server.
//         * getSession will by default return the session object if its available.
//         * else, it will create a new one and then return.
//         * we can do - getSession(false) if we don't want to create one.
//         */
//        HttpSession session = req.getSession();
//        session.setAttribute("val", result);
//        resp.sendRedirect(req.getContextPath() + "/squared");
//    }

    //    LEVEL 5 =================================== [ COOKIES ]
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;

        // we see that the browser send the cookies initially also.
        System.out.println("add servlet");
        Cookie []cookies = req.getCookies();
        for(Cookie c : cookies){
            System.out.println(c.getName());
        }

        /*
        * the browser sends the cookies along with the request. it sends all the cookies corresponding
        * to our domain in the form of an array because it doesnt know which cookie to send and which
        * not. when the client first hits the servlet, we give him a cookie. from next time, we
        * get our own cookie also. but it sends the cookies associated with OUR domain only. */
        Cookie cookie = new Cookie("val", result+"");
        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/squared");
    }

/**
 * VERY IMPORTANT LINK -
 * https://stackoverflow.com/questions/19896730/confusion-about-how-java-web-session-handeling-works
 * -demystifying-cookies-and-h#:~:text=The%20Servlet%20HTTP%20session%20uses,stores%20it%20in%20its%
 * 20map.
 *
 * whenever we send a request first time to the server [like tomcat], it creates a session object
 * for the corresponding user. and then it attaches a set-cookie header in the response of that
 * request - JESSIONID with a unique identifier of the session object. the session object is actually
 * a map to store diff info we require. now, the jsessionid is stored as a cookie in the browser and
 * is sent in all subsequent requests with the cookie header, so that the server identifies the
 * corresponding user that yes i know u and we process the request accordingly.
 * it attaches the identified map with the request object so that we can use that easily.
 * similarly, when we set cookies, they are also sent by the set-cookie header. but we are doing that
 * with some abstract methods like the addCookie.
 * session and cookie are different. cookie is basically a key value pair. while session is an object.
 * session is stored in the server and cookie on the browser.
 * they are both used to maintain some info across multiple requests and responses.
 */

}
