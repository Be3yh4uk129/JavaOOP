class Order {
    String orderId;
    Customer customer;
    Product product;
    int quantity;
    double totalPrice;
    String status;
    String paymentMethod;
    public Order (String orderId, Customer customer, Product product, int quantity, double totalPrice, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public void cancelOrder() {
        if (!status.equals("Cancelled")) {
            product.increaseStock(quantity);
            status = "Cancelled";
        }
    }
    public void displayOrderDetails() {
        System.out.println("Order Id: " + orderId);
        System.out.println("Customer: " + customer);
        System.out.println("Product: " + product);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Status: " + status);
    }
    public double getTotalPrice() {
        return totalPrice;
    }
}
