import java.sql.*;

public class Database {
    public static void main(String[] args) {

        ConsoleInteraction system = new ConsoleInteraction();
        system.createUser("admin", "admin");
        createTables();
        insertProduct("Laptop", 10, 999.99);
        insertProduct( "Mouse", 50, 19.99);
        insertProduct( "Pen obama", 50, 10.99);
        insertProduct("Notebook", 150, 15.99);
        insertProduct( "Banana", 200, 200.99);
        insertProduct("Keyboard", 50, 50.99);
        insertProduct("Printer", 5, 15.99);
        insertProduct("Headphones", 30, 75.99);
        insertProduct("Speaker", 25, 90.99);
        insertProduct("Webcam", 10, 120.99);

    }

    private static void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id SERIAL PRIMARY KEY,"
                + "password VARCHAR(50) NOT NULL,"
                + "email VARCHAR(50) UNIQUE NOT NULL,"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";
        String createProductsTable = "CREATE TABLE IF NOT EXISTS products ("
                + "product_id SERIAL PRIMARY KEY,"
                + "product_name VARCHAR(50) UNIQUE NOT NULL,"
                + "product_stock SMALLINT NOT NULL,"
                + "product_price DOUBLE PRECISION NOT NULL"
                + ")";
        String createOrdersTable = "CREATE TABLE IF NOT EXISTS orders ("
                + "order_id SERIAL PRIMARY KEY,"
                + "user_id INT NOT NULL,"
                + "product_id INT NOT NULL,"
                + "quantity SMALLINT NOT NULL,"
                + "total_price DOUBLE PRECISION NOT NULL,"
                + "status VARCHAR(30) NOT NULL,"
                + "payment_method VARCHAR(30) NOT NULL"
                + ")";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createProductsTable);
            stmt.execute(createOrdersTable);
            System.out.println("Таблицы созданы успешно.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertProduct(String name, int stock, double price) {
        String insertProductSQL = "INSERT INTO products (product_name, product_stock, product_price) VALUES ( ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertProductSQL)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            System.out.println("Добавлен продукт: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
