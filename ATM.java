import java.util.Scanner;

public class ATM {
    // Instance variables for storing balance and pin
    private int balance;
    private int pin;

    // Constructor to initialize ATM object with balance and pin
    public ATM(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    // Method to display the menu options
    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }

    // Method to deposit a specified amount into the balance
    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
    }

    // Method to withdraw a specified amount from the balance
    public void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient Funds!");
            return;
        }
        balance = balance - amount;
        System.out.println("Amount Withdrawn: " + amount);
    }

    // Method to return the current balance
    public int getBalance() {
        return balance;
    }

    // Method to validate the entered pin against the stored pin
    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    // Method to change the pin to a new pin
    public void changePin(int newPin) {
        pin = newPin;
        System.out.println("Pin Changed Successfully.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an ATM object with initial balance and pin
        ATM atm = new ATM(2000, 1234);

        // Prompt the user to enter the pin
        System.out.println("Enter the Pin:");
        int pin = sc.nextInt();

        // Validate the entered pin
        if (atm.validatePin(pin)) {
            int option = 0;
            // Loop until the user chooses to exit
            while (option != 5) {
                atm.displayMenu(); // Display the menu
                System.out.print("Choose an option: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        // Display current balance
                        System.out.println("Balance: " + atm.getBalance());
                        break;

                    case 2:
                        // Deposit amount
                        System.out.print("Enter Amount: ");
                        int depositAmount = sc.nextInt();
                        atm.deposit(depositAmount);
                        break;

                    case 3:
                        // Withdraw amount
                        System.out.print("Enter Amount: ");
                        int withdrawAmount = sc.nextInt();
                        atm.withdraw(withdrawAmount);
                        break;

                    case 4:
                        // Change pin
                        System.out.print("Enter New Pin: ");
                        int newPin = sc.nextInt();
                        atm.changePin(newPin);
                        break;

                    case 5:
                        // Exit the program
                        System.out.println("Thank You for using the ATM!");
                        break;

                    default:
                        System.out.println("Invalid Option. Please try again.");
                        break;
                }
            }
        } else {
            // Invalid pin message
            System.out.println("You have entered an invalid pin!");
        }
    }
}
