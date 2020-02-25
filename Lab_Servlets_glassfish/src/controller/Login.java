package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static java.lang.System.out;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            String username = request.getParameter("login");
            String pwd = request.getParameter("password");

            if(LoginUser.validate(username, pwd)) {
                RequestDispatcher rd = request.getRequestDispatcher("process");
                rd.forward(request, response);
            } else {
                out.print("Sorry username or password wrong");
                RequestDispatcher rd=request.getRequestDispatcher("home");
                rd.include(request,response);
            }
        }

        out.close();
    }
}
