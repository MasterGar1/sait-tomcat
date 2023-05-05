import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String db = "jdbc:mariadb://localhost/bazasait";
        String reqName = request.getParameter("usr");
        String reqPass = request.getParameter("pwd");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn  = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """
                    SELECT * FROM potrebiteli;
                           """;
            ResultSet rs = stmt.executeQuery(query);
            conn.close();
            
            while(rs.next()) {
                String name = rs.getString(2);
                String pass = rs.getString(3);
                if (reqName.equals(name) && reqPass.equals(pass)) {
                    Cookie c = new Cookie("name", name);
                    response.addCookie(c);
                    response.getWriter().println("login success");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}