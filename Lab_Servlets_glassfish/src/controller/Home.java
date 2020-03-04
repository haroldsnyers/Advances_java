package controller;

import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// As of Servlet API 3.0, the @WebServlet annotation provides configuration
// settings that used to be included in the deployment descriptor web.xml.
// The annotation below conveys the same information as the following lines
// in the web.xml file in a much easier way:


@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            Cookie[] cookies = request.getCookies();
            Cookie user = findCookie("user",cookies);

            String username = request.getParameter("login");
            String pwd = request.getParameter("password");

            if(request.getParameter("logout") != null){
                logout.setValue("true");
                user.setValue("");

                response.addCookie(logout);
                response.addCookie(user);

                out.println("<h1>You are logged out </h1>");
            }

            // user previously connected with cookie
            if (!user.getValue().equals("")) {
                out.println("<h1>You are connected as " +
                        user.getValue() +
                        "</h1>");

                makeFormButtons(out);

            }
            else if(LoginUser.validate(username, pwd) &&
                    user.getValue().equals("")) {
                user.setValue(username);

                response.addCookie(user);

                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "home");
                dispatcher.forward(request, response);
            } else {
                out.print("<p>Sorry username or password wrong</p>");
                makeForm(out);
                // RequestDispatcher rd=request.getRequestDispatcher("login");
                // rd.include(request,response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            Cookie[] cookies = request.getCookies();
            Cookie user = findCookie("user",cookies);
            Cookie logout = findCookie("logout",cookies);

            // log out of the system
            if(request.getParameter("logout") != null) {
                if (logout.getValue().equals("false")) {
                    logout.setValue("true");
                }
            }

            // user not connected
            if(user.getValue().equals("")) {
                makeForm(out);
            }

            String cssTag="<link rel='stylesheet' type='text/css' href='css/style.css'>";
            out.println("<!DOCTYPE html><html><head><title>Home</title>" + cssTag +"</head><body>");

            // user exist and is connected (thus cookies exist too)
            if(!user.getValue().equals("") &&
                    logout.getValue().equals("false")){
                out.println("<h1>You are connected as " +
                        user.getValue()+
                        "</h1>");

                makeFormButtons(out);
            }

            // user asked to be log out
            if(logout.getValue().equals("true") &&
                    request.getParameter("logout") != null){
                logout.setValue("false");
                user.setValue("");
                out.println("<h1>You are logged out </h1>");
            }

            out.println("</body>" +
                    "</html> ");

            response.addCookie(logout);
            response.addCookie(user);
        }

    }

    private Cookie findCookie(String name, Cookie[] cookies) {
        Cookie n = null;
        for(Cookie c: cookies){
            if(c.getName().equals(name)){
                n = c;
            }
        }
        if(n == null){
            n = new Cookie(name,"");
        }
        return n;
    }

    protected void makeForm(PrintWriter out) {
        out.println(
                "<form action='" + "home" + "' method='POST' >\n"
                + "Login: <input type='text' name='login' />\n"
                + "Password: <input type='password' name='password' />\n"
                + "<input type='submit' value='Log in' />\n"
                + "</form"
        );

        out.close();
    }

    private void makeFormButtons(PrintWriter out) {
        out.println("<div class='button_form'><form action=\"home\" method=\"get\">\n" +
                "    <input type=\"submit\" value=\"continue\" name=\"continue\">\n" +
                "</form>");
        out.println("<form action=\"home\" method=\"get\">\n" +
                "    <input type=\"submit\" value=\"logout\" name=\"logout\">\n" +
                "</form></div>");
    }

}