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

    private String user = "";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            user = request.getParameter("login");
            out.println("<h1>You are connected as " +
                    request.getParameter("login") +
                    "</h1>");

            out.println("<a href='process'>continue</a> "
                    + "<a href='logout'>logout</a>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>You are connected as " +
                    request.getParameter("login") +
                    "</h1>");

            out.println("<a href='process'>continue</a> "
                    + "<a href='logout'>logout</a>");

        }
    }
}
