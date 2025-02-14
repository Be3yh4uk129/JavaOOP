import java.sql.*;
public class ConsoleInteraction {
    private User currentUser = null;
    public void createUser (String email, String password) {
        String insertUserSql = "INSERT INTO users (email, password) VALUES (?, ?) ON CONFLICT (email) DO NOTHING";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertUserSql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("✅ User signed up successfully!");
            } else {
                System.out.println("❌ User exists already.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                currentUser = new Customer(rs.getInt("id"), rs.getString("password"), email);
                System.out.println("✅ Signed in successfully!");
            } else {
                System.out.println("❌ User not found.");
            }
        } catch (SQLException e) {
            System.out.println("⛔ Sign in error: " + e.getMessage());
        }
    }
    public void displayProducts() {
        String sql = "SELECT * FROM products";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("📦 List of available products:");
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("product_price");
                int stock = rs.getInt("product_stock");
                System.out.println("🔹 ID: " + id + " | " + name + " | Цена: $" + price + " | В наличии: " + stock);
            }
        } catch (SQLException e) {
            System.out.println("❌ Product loading error: " + e.getMessage());
        }
    }
    public void placeOrder(int productId, int quantity, String paymentMethod) {
        String selectProductSQL = "SELECT * FROM products WHERE product_id = ?";
        String insertOrderSQL = "INSERT INTO orders (user_id, product_id, quantity, total_price, status, payment_method) VALUES (?, ?, ?, ?, ?, ?)";
        String updateStockSQL = "UPDATE products SET product_stock = product_stock - ? WHERE product_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectProductSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertOrderSQL);
             PreparedStatement updateStockStmt = conn.prepareStatement(updateStockSQL)) {
            selectStmt.setInt(1, productId);
            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                double price = rs.getDouble("product_price");
                int stock = rs.getInt("product_stock");
                if (stock >= quantity) {
                    double totalPrice = price * quantity;
                    insertStmt.setInt(1, currentUser.getId());
                    insertStmt.setInt(2, productId);
                    insertStmt.setInt(3, quantity);
                    insertStmt.setDouble(4, totalPrice);
                    insertStmt.setString(5, "Placed");
                    insertStmt.setString(6, paymentMethod);
                    insertStmt.executeUpdate();
                    updateStockStmt.setInt(1, quantity);
                    updateStockStmt.setInt(2, productId);
                    updateStockStmt.executeUpdate();
                    System.out.println("✅ Order placed successfully!");
                } else {
                    System.out.println("❌ Not enough products in stock.");
                }
            } else {
                System.out.println("❌ Product not found.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error in order placement: " + e.getMessage());
        }
    }
    public void cancelOrder(int productId) {
        String selectOrderSQL = "SELECT order_id, quantity, status FROM orders WHERE product_id = ? AND user_id = ?";
        String deleteOrderSQL = "DELETE FROM orders WHERE product_id = ? AND user_id = ?";
        String updateStockSQL = "UPDATE products SET product_stock = product_stock + ? WHERE product_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectOrderSQL);
             PreparedStatement deleteStmt = conn.prepareStatement(deleteOrderSQL);
             PreparedStatement updateStockStmt = conn.prepareStatement(updateStockSQL)) {

            // 🔹 Проверяем, есть ли заказ с таким productId у текущего пользователя
            selectStmt.setInt(1, productId);
            selectStmt.setInt(2, currentUser.getId()); // Убедимся, что заказ принадлежит пользователю
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int orderId = rs.getInt("order_id");  // ID заказа
                int quantity = rs.getInt("quantity"); // Количество товара
                String status = rs.getString("status");

                if (!status.equals("Placed")) {
                    System.out.println("❌ An order cannot be canceled as it has already been processed.");
                    return;
                }

                // 🔹 Удаляем заказ из таблицы orders
                deleteStmt.setInt(1, productId);
                deleteStmt.setInt(2, currentUser.getId());
                deleteStmt.executeUpdate();

                // 🔹 Возвращаем товар на склад
                updateStockStmt.setInt(1, quantity);
                updateStockStmt.setInt(2, productId);
                updateStockStmt.executeUpdate();

                System.out.println("✅ The order for product #” + productId + ” has been canceled. The product has been returned.");

            } else {
                System.out.println("❌ An order with this product is not found or does not belong to you.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error during cancel an order: " + e.getMessage());
        }
    }

}
