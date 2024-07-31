import java.util.Scanner;

class Customer {
    private String name;
    private String accountNumber;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private Customer customer;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        Customer customer = new Customer(name, accountNumber);
        Account account = new Account(accountNumber, customer);
        
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.print("Amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (account.deposit(deposit)) System.out.println("Deposited 3" + deposit);
                    else System.out.println("Invalid amount.");
                    break;
                case 2:
                    System.out.print("Amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (account.withdraw(withdraw)) System.out.println("Withdrew " + withdraw);
                    else System.out.println("Insufficient balance or invalid amount.");
                    break;
                case 3:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        
        scanner.close();
    }
}
