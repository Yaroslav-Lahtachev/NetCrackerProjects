import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class DefaultValidationServlet extends HttpServlet {


    private final int N = 3;
    public Integer invalidPassword = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean remember = (req.getParameter("remember") != null);
        HttpSession session = req.getSession(true);

        //впервые на сайте
        if (!remember || (session.getAttribute(new String("User")) == null)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            File file = new File(getServletContext().getRealPath("WEB-INF/user.txt"));
            List<User> users = new ArrayList<>();
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                    users.add(new User(stringTokenizer.nextToken(), stringTokenizer.nextToken()));
                    line = bufferedReader.readLine();
                }
            }
            int i = users.indexOf(new User(login, password));
            if (i == -1) {
                resp.setContentType("text/html");
                String site = new String("http://localhost:8080/create.html");
                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                resp.setHeader("Location", site);
            } else {
                if (users.get(i).getPassword().equals(password)) {

                    session.setAttribute(new String("User"), login);
                    resp.setContentType("text/html");
                    PrintWriter out = resp.getWriter();
                    out.println("<h3>Hello, " + login + "</h3>" +
                            "<h3>The password is correct</h3>" +
                            "<a href = \"/\">return</a>");
                } else {
                    if (session.isNew()) {
                        session.setAttribute(new String("InvalidPassword"), 0);
                    }
                    invalidPassword = (Integer) session.getAttribute(new String("InvalidPassword"));
                    System.out.println(invalidPassword);
                    if (invalidPassword == null)
                        invalidPassword = 0;

                    if (invalidPassword >= N) {
                        users.remove(i);
                        try (FileWriter fileWriter = new FileWriter(file)) {
                            for (User user : users) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(user.getLogin()).append(" ");
                                stringBuilder.append(user.getPassword());
                                String data = stringBuilder.toString();
                                fileWriter.write(data);
                                fileWriter.write('\n');
                            }
                        }
                        resp.setContentType("text/html");
                        String site = new String("http://localhost:8080/create.html");
                        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                        resp.setHeader("Location", site);
                    } else {
                        session.setAttribute(new String("InvalidPassword"), invalidPassword + 1);
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid password");
                    }
                }
            }
        } else {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h3>Hello, " + session.getAttribute(new String("User")) + "</h3>" +
                    "<h3>The password is correct</h3>" +
                    "<a href = \"/\">return</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}