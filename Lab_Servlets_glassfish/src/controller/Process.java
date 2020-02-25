package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Process", urlPatterns = {"/process"})
public class Process extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("login");
        out.println("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Home</title>" +
                "</head>" +
                "<body>" +
                "<form action='login' method='POST' >\n"
                + "Login: <input type='text' name='login' />\n"
                + "Password: <input type='password' name='password' />\n"
                + "<input type='submit' value='Log in' />\n"
                + "</form>"
                + "</body>"
        );
        out.print("Welcome "+n);

        out.close();
    }
}
