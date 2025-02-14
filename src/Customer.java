import java.util.ArrayList;

class Customer extends User {
    ArrayList<Order> orders;
    public Customer(int userId, String password, String email) {
        super(userId, password, email);
        this.orders = new ArrayList<>();
    }
    public void displayDetails() {
        System.out.println("Customer Id: " + userId);
        System.out.println("password: " + password);
        System.out.println("Email: " + email);
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
