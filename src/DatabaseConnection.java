import java.sql.*;
public class DatabaseConnection {
    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/";
    private static final String username = "postgres";
    private static final String password = "Amir2006";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

}
