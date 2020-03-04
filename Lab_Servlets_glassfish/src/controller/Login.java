package controller;

import com.sun.deploy.nativesandbox.comm.Response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static java.lang.System.out;

// @WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        makeForm(out);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            String username = request.getParameter("login");
            String pwd = request.getParameter("password");
            log("gekko");
            if(LoginUser.validate(username, pwd)) {
                String n = request.getParameter("login");
                RequestDispatcher dispatcher = request.getRequestDispatcher("process");
                dispatcher.forward(request, response);
            } else {
                out.print("Sorry username or password wrong");
                makeForm(out);
                // RequestDispatcher rd=request.getRequestDispatcher("login");
                // rd.include(request,response);
            }
        }
    }

    protected void makeForm(PrintWriter out) {
        out.println("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Home</title>" +
                "</head>" +
                "<body>" +
                "<form action='" + "login" + "' method='POST' >\n"
                + "Login: <input type='text' name='login' />\n"
                + "Password: <input type='password' name='password' />\n"
                + "<input type='submit' value='Log in' />\n"
                + "</form>"
                + "</body>"
        );

        out.close();
    }
}
