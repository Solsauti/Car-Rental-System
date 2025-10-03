import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ==== LOGIN PHASE ====
        String correctUsername = "admin";
        String correctPassword = "12345";

        Console console = System.console();
        Scanner sc = new Scanner(System.in);

        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            String password;
            if (console != null) {
                // Works in terminal (password hidden with *)
                char[] passwordArray = console.readPassword("Enter password: ");
                password = new String(passwordArray);
            } else {
                // Fallback for IDE (password visible)
                System.out.print("Enter password: ");
                password = sc.nextLine();
            }

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("✅ Welcome, " + username + "!");
                success = true;
            } else {
                attempts++;
                System.out.println("❌ Incorrect username or password. Attempts left: " + (3 - attempts));
            }
        }

        if (!success) {
            System.out.println("⛔ Account locked.");
            return; // Exit program
        }

        // ==== RENTAL SYSTEM PHASE ====
        RentalAgency agency = new RentalAgency();

        // Sample data
        agency.addCar(new Car("C001", "Toyota", "Corolla", 3500));
        agency.addCar(new Car("C002", "Honda", "Civic", 4000));

        agency.addCustomer(new Customer("CU001", "John Doe", "john@example.com", "0712345678"));
        agency.addCustomer(new Customer("CU002", "Jane Smith", "jane@example.com", "0723456789"));

        // Menu loop
        int choice;
        do {
            System.out.println("\n===== CAR RENTAL MENU =====");
            System.out.println("1. View all cars");
            System.out.println("2. View all customers");
            System.out.println("3. Rent a car");
            System.out.println("4. Return a car");
            System.out.println("5. View all transactions");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    agency.displayAllCars();
                    break;
                case 2:
                    agency.displayAllCustomers();
                    break;
                case 3:
                    System.out.print("Enter Transaction ID: ");
                    String tId = sc.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String custId = sc.nextLine();
                    System.out.print("Enter Car ID: ");
                    String carId = sc.nextLine();
                    System.out.print("Enter Rental Days: ");
                    int days = sc.nextInt();
                    sc.nextLine();
                    agency.rentCar(tId, custId, carId, days);
                    break;
                case 4:
                    System.out.print("Enter Car ID to return: ");
                    String returnId = sc.nextLine();
                    agency.returnCar(returnId);
                    break;
                case 5:
                    agency.displayAllTransactions();
                    break;
                case 0:
                    System.out.println("👋 Thank you for using Car Rental System!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
