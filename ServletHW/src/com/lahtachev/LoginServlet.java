package com.lahtachev;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    final private String pass = "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        if (userPassword.equalsIgnoreCase(pass)) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h3>Hello, " + userLogin + "</h3>" +
                    "<h3>The password is correct</h3>" +
                    "<a href = \"/\">return</a>");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid password");
        }
    }
}
