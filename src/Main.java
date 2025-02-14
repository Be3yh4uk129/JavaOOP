import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our eShop!");
        Scanner scanner = new Scanner(System.in);
        int number;
        ConsoleInteraction system = new ConsoleInteraction();
        do {
            System.out.println("\nList");
            System.out.println("1) Create a new user");
            System.out.println("2) Sign in");
            System.out.println("3) Display the products");
            System.out.println("4) Place an order");
            System.out.println("5) Cancel an order");
            System.out.println("6) Display my orders");
            System.out.println("7) Exit");
            System.out.print("Enter the number: ");

            number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 1: {
                    System.out.println("Hello! You need to sign up first! \n Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter the password: ");
                    String password = scanner.nextLine();
                    system.createUser(email, password);
                    System.out.println("You registered successfully!");
                    break;
                }
                case 2:
                    System.out.println("If you already have account\n Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter the password: ");
                    String password = scanner.nextLine();
                    system.loginUser(email, password);
                    break;
                case 3:
                    system.displayProducts();
                    break;

                case 4:
                    System.out.println("Enter the id of product you want to place:");
                    int id = scanner.nextInt();
                    System.out.println("Enter the quantity");
                    int quantity = scanner.nextInt();
                    System.out.println("CreditCard or PayPalPayment:");
                    String paymentMethod = scanner.nextLine();
                    system.placeOrder(id, quantity, paymentMethod);
                    break;
                case 5:
                    System.out.println("Enter the id of product you want to cancel:");
                    int productId = scanner.nextInt();
                    system.cancelOrder(productId);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (number != 7);

    }
}