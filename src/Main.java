import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our eShop!");
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("\nList");
            System.out.println("1) Add a new user");
            System.out.println("2) Sign in");
            System.out.println("3) Display the products");
            System.out.println("4) Place an order");
            System.out.println("5) Display my orders");
            System.out.println("6) Cancel an order");
            System.out.println("7) Exit");
            System.out.print("Enter the number: ");

            number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 1:
                    System.out.println("Hello! You need to sign up first! \n Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the password: ");
                    String password = scanner.nextLine();
                    System.out.println("You registered successfully!");

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (number != 7);

    }
}
        /*Admin sanyok = new Admin(007, "Sanchous", "Admin@mail.ru");
        Admin valera = new Admin(001, "Valera", "Admin@mail.ru");
        Customer pivnoy = new Customer(1, "Pivko", "ukranianPivko@mail.uk", "Bar pushkina 9/12");
        Customer guy = new Customer(2, "Guyechniy", "kliuch@mail.ru", "masterskaya 6/2");
        Customer notGuy = new Customer(3, "NeGaechniy" , "ru@mail.ru", "russia 2/2");
        Customer chill = new Customer(4, "Chill", "chill@mail.ru", "chill 8/7");
        Customer monkey = new Customer(5, "Ua ua", "monk@mail.ru", "guy 4/2");

        Product product1 = new Product("1", "desheviy pk", 100, 1000);
        Product product2 = new Product("2", "pen obama", 50, 10);
        Product product3 = new Product("3", "notebook", 150, 15);
        Product product4 = new Product("4", "banan", 200, 200);
        Product product5 = new Product("5","keyboard", 50, 50);
        Product product6 = new Product("6","mouse", 60, 25);
        Product product7 = new Product("7","printer", 5, 15);
        Product product8 = new Product("8","headphones", 30, 75);
        Product product9 = new Product("9","speaker", 25, 90);
        Product product10 = new Product("10","webcam", 10, 120);

        sanyok.addProduct(product1);
        sanyok.addProduct(product2);
        sanyok.addProduct(product3);
        sanyok.addProduct(product4);
        sanyok.addProduct(product5);
        sanyok.addProduct(product6);
        sanyok.addProduct(product7);
        sanyok.addProduct(product8);
        sanyok.addProduct(product9);
        sanyok.addProduct(product10);


        pivnoy.placeOrder(product1, 10, new CreditCardPayment("1234-2424", "Pivko"));
        guy.placeOrder(product2, 10, new PayPalPayment("alz;das;dl@mail.ru"));
        notGuy.placeOrder(product5, 35, new PayPalPayment("afdsjfnd2@mail.ru"));
        chill.placeOrder(product10, 47, new PayPalPayment("jdjdjdj@mail.com"));
        monkey.placeOrder(product4, 101, new CreditCardPayment("1232-6576", "mok"));

        System.out.println(product4.getStock());
        monkey.placeOrder(product4, 100, new CreditCardPayment("7853-8678", "mok"));
        sanyok.updateStock("4", 1);
        monkey.placeOrder(product4, 100, new PayPalPayment("alz;das;dl@mail.ru"));
        System.out.println(product4.getStock());
        valera.removeProduct("7");

        System.out.println("\nUsers");
        sanyok.displayDetails();
        valera.displayDetails();
        pivnoy.displayDetails();
        guy.displayDetails();
        notGuy.displayDetails();
        chill.displayDetails();
        monkey.displayDetails();
        System.out.println("\nProducts");
        sanyok.displayAllProducts();
        System.out.println("\nOrders");
        for (Order order : pivnoy.orders) {
            order.displayOrderDetails();
        }
        for (Order order : guy.orders) {
            order.displayOrderDetails();
        }
        for (Order order : notGuy.orders) {
            order.displayOrderDetails();
        }
        for (Order order : chill.orders) {
            order.displayOrderDetails();
        }
        for (Order order : monkey.orders) {
            order.displayOrderDetails();
        }
    }

}*/