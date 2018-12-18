import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
            users.add(new User(login, password));
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
            PrintWriter out = resp.getWriter();
            out.println("<h3>Hello, " + login + "</h3>" +
                    "<a href = \"/\">return</a>");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username already exists");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}