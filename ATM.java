import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Map<String, Double> accountBalances;

    public ATM() {
        accountBalances = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        if (!accountBalances.containsKey(accountNumber)) {
            accountBalances.put(accountNumber, initialBalance);
            System.out.println("Account created successfully. Account number: " + accountNumber);
        } else {
            System.out.println("Account already exists with account number: " + accountNumber);
        }
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            if (amount > 0) {
                double balance = accountBalances.get(accountNumber);
                balance += amount;
                accountBalances.put(accountNumber, balance);
                System.out.println("Deposit successful. New balance for account " + accountNumber + ": " + balance);
            } else {
                System.out.println("Invalid amount. Please try again.");
            }
        } else {
            System.out.println("Account not found with account number: " + accountNumber);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double balance = accountBalances.get(accountNumber);
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                accountBalances.put(accountNumber, balance);
                System.out.println("Withdrawal successful. New balance for account " + accountNumber + ": " + balance);
            } else {
                System.out.println("Insufficient funds or invalid amount. Please try again.");
            }
        } else {
            System.out.println("Account not found with account number: " + accountNumber);
        }
    }

    public double checkBalance(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            return accountBalances.get(accountNumber);
        } else {
            System.out.println("Account not found with account number: " + accountNumber);
            return 0.0;
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter the initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    atm.createAccount(accountNumber, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter the account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(accountNumber, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter the account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(accountNumber, withdrawalAmount);
                    break;

                case 4:
                    System.out.print("Enter the account number: ");
                    accountNumber = scanner.next();
                    double balance = atm.checkBalance(accountNumber);
                    System.out.println("Your current balance for account " + accountNumber + " is: " + balance);
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            scanner.nextLine(); // Consume the newline character
            System.out.println();
        }
    }
}
