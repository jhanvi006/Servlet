package com.firstservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" }
//        initParams = {
//                @WebInitParam(name = "user", value = "jhanvi"),
//                @WebInitParam(name = "password", value = "jhanvi")
//        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* get request parameters for userId and pwd */
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        /* get servlet config params */
        String userId = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
//        if (userId.equals(user) && password.equals(pwd)){
        if (validateUser(user)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        }
        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
//            out.println("<font color=red>Either username or password is wrong.</font>");
            out.println("<font color=red>Username is incorrect.</font>");
            rd.include(request, response);
        }
    }
    private boolean validateUser(String user) {
        String regex = "^[A-Z][A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user);
        boolean result = matcher.matches();
        return result;
    }
}
