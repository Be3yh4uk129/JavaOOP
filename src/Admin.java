import java.util.ArrayList;

class Admin extends User {
    ArrayList<Product> products;
    public Admin(int userId, String password, String email) {
        super(userId, password, email);
        this.products = new ArrayList<>();
    }
    public void displayDetails() {
        System.out.println("User id: " + userId + ", password: " + password + ", email: " + email);
    }
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }
    public void removeProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        System.out.println("Product removed: " + productId);
    }
    public void updateStock(String productId, int newStock) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.increaseStock(newStock);
                System.out.println("Stock updated: " + product.getName());
                return;
            }
        }
        System.out.println("Product not found: " + productId);
    }
    public void displayAllProducts() {
        for (Product product : products) {
            product.displayDetails();
        }
    }

}
