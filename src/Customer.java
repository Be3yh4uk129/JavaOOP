import java.util.ArrayList;

class Customer extends User {
    ArrayList<Order> orders;
    String shippingAddress;
    public Customer(int userId, String name, String email, String shippingAddress) {
        super(userId, name, email);
        this.orders = new ArrayList<>();
        this.shippingAddress = shippingAddress;
    }
    public void displayDetails() {
        System.out.println("Customer Id: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Shipping Address: " + shippingAddress);
    }
    public void placeOrder(Product product, int quantity, Payment paymentMethod) {
        if (product.getStock() >= quantity) {
            double totalPrice = product.getPrice() * quantity;
            product.reduceStock(quantity);
            Order order = new Order("Order" + (orders.size() + 1), this, product, quantity, totalPrice, "Placed");
            orders.add(order);
            paymentMethod.processPayment(totalPrice);
            System.out.println("Order placed successfully");
        }
        else {
            System.out.println("Not enough stock");
        }
    }
    public void cancelOrder(Order order) {
        if (orders.contains(order)) {
            order.cancelOrder();
            System.out.println("Order Canceled");
        }
        else {
            System.out.println("Order Not Found");
        }
    }
}
