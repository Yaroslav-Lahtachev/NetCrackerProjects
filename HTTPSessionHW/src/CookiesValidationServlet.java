import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CookiesValidationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String login = null;
        boolean guest = true;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                guest = false;
                login = cookie.getValue();
            }
        }
        if (guest) {
            login = req.getParameter("login");
            String userPass = req.getParameter("password");

            File file = new File(getServletContext().getRealPath("WEB-INF/user.txt"));
            List<User> userList = new ArrayList<>();

            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                    userList.add(new User(stringTokenizer.nextToken(), stringTokenizer.nextToken()));
                    line = bufferedReader.readLine();
                }
            }
            int i = userList.indexOf(new User(login, userPass));

            if (i == -1) {
                resp.setContentType("text/html");
                String site = new String("http://localhost:8080/create.html");
                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                resp.setHeader("Location", site);
            } else {
                if (userList.get(i).getPassword().equals(userPass)) {
                    Cookie userNameCookie = new Cookie("login", login);
                    userNameCookie.setMaxAge(60 * 60 * 24);
                    resp.addCookie(userNameCookie);
                    resp.setContentType("text/html");
                    PrintWriter out = resp.getWriter();
                    out.println("<h3>Hello, " + login + "</h3>" +
                            "<h3>The password is correct</h3>" +
                            "<a href = \"/\">return</a>");
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid password");
                }
            }
        } else {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h3>Hello, " + login + "</h3>" +
                    "<h3>The password is correct</h3>" +
                    "<a href = \"/\">return</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}