public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    public void processPayment(double amount) {
        System.out.println("Processing " + amount + " payment");
    }
}


