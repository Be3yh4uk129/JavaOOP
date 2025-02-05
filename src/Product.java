public class Product {
    String productId;
    String name;
    double price;
    int stock;
    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public void reduceStock(int quantity) {
        stock -= quantity;
    }
    public void increaseStock(int quantity) {
        stock += quantity;
    }
    public void displayDetails() {
        System.out.println("Product Id: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
    }
    public String getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
}
