public class PayPalPayment implements Payment {
    private final String email;
    public PayPalPayment(String email) {
        this.email = email;
    }
    public void processPayment(double amount) {

        System.out.println("Processing PayPal " + amount + " payment");

    }
}

