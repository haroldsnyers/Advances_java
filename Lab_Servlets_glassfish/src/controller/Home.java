package controller;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// As of Servlet API 3.0, the @WebServlet annotation provides configuration
// settings that used to be included in the deployment descriptor web.xml.
// The annotation below conveys the same information as the following lines
// in the web.xml file in a much easier way:
//
// <servlet>
//    <servlet-name>Home</servlet-name>
//    <servlet-class>controller.Home</servlet-class>
// </servlet>
// <servlet-mapping>
//    <servlet-name>Home</servlet-name>
//    <url-pattern>/home</url-pattern>
// </servlet-mapping>

@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {
    private boolean connected = false;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            Enumeration<String> Parameters = request.getParameterNames();
            System.out.println(Parameters);
            System.out.println("hey");

            out.println("<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<title>Home</title>" +
                    "</head>" +
                    "<form action='login' method='POST' >\n"
                    + "Login: <input type='text' name='login' />\n"
                    + "Password: <input type='password' name='password' />\n"
                    + "<input type='submit' value='Log in' />\n"
                    + "</form>"
            );
        }
    }
}