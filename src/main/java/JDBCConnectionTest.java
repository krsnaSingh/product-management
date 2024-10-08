import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/productdb";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the database!");
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
