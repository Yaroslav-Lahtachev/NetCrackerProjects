package com.lahtachev;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calendar calendar = new GregorianCalendar();
        String noon;

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        if (calendar.get(Calendar.AM_PM) == 0)
            noon = "AM";
        else
            noon = "PM";
        String currentTime = hour + ":" + minute + " " + noon;
        String currentDate = day + "." + month + "." + year;

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Date getter";
        out.println("<html>\n" +
                "<head>" +
                "<title>" + title + "</title>" +
                "<link href=\"styles.css\" rel=\"stylesheet\">" +
                "</head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#696969\">\n" +
                "<th>Name</th><th>Value</th>\n" +
                "</tr>\n"
        );
        out.print("<tr bgcolor = \"#808080\">\n><td>" + "Current Date" + "</td>\n");
        out.println("<td > " + currentDate + "</td></tr>\n");

        out.print("<tr bgcolor = \"#696969\">\n><td>" + "Current Time" + "</td>\n");
        out.println("<td> " + currentTime + "</td></tr>\n");

        out.print("<tr bgcolor = \"#808080\">\n><td>" + "User-Agent" + "</td>\n");
        out.println("<td> " + req.getHeader("User-Agent") + "</td></tr>\n");

        out.println("</table>\n <a href = \"/\">return</a>\n </body></html>");
    }
}