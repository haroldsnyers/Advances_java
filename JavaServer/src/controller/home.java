package controller;

import sun.rmi.runtime.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "home")
public class home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            Cookie[] cookies = request.getCookies();
            Cookie user = findCookie("user", cookies);
            Cookie logout = findCookie("logout",cookies);

            String username = request.getParameter("user");
            String pwd = request.getParameter("pwd");

            if(request.getParameter("logout") != null){
                logout.setValue("true");
                user.setValue("");

                response.addCookie(logout);
                response.addCookie(user);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/logout1.jsp");
                dispatcher.forward(request, response);
            }

            // user previously connected with cookie
            if (!user.getValue().equals("")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/process1.jsp");
                dispatcher.forward(request, response);
            }
            else if(LoginUser.validate(username, pwd) &&
                    user.getValue().equals("")) {
                user.setValue(username);
                logout.setValue("false");
                response.addCookie(logout);
                response.addCookie(user);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/process1.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("state", "10");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login1.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Cookie user = findCookie("user",cookies);
        Cookie logout = findCookie("logout",cookies);

        log(user.getValue());

//        // log out of the system
//        if(request.getParameter("logout") != null) {
//            if (logout.getValue().equals("false")) {
//                logout.setValue("true");
//            }
//        }

        // user exist and is connected (thus cookies exist too)
        if(!user.getValue().equals("") &&
                logout.getValue().equals("false")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/process1.jsp");
            dispatcher.forward(request, response);
//        }
//
//        // user asked to be log out
//         else if(logout.getValue().equals("true") &&
//                request.getParameter("logout") != null){
//            logout.setValue("false");
//            user.setValue("");
//
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login1.jsp");
            dispatcher.forward(request, response);
        }
        response.addCookie(logout);
        response.addCookie(user);

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
}
