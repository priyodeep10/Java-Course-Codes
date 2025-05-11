import java.util.*;

class BankAccount {
    String accountId;
    String holderName;
    double accountBalance;

    // Constructor to initialize the account
    public BankAccount(String accountId, String holderName, double initialDeposit) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.accountBalance = initialDeposit;
    }

    // Method to deposit money
    void depositMoney(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    void withdrawMoney(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid or insufficient amount.");
        }
    }

    // Method to display account details
    void displayAccountDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Balance: ₹" + accountBalance);
    }
}

public class BankSystem {
    static Scanner sc = new Scanner(System.in);  // Renamed Scanner to 'sc'
    static HashMap<String, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        int userChoice;
        do {
            // Displaying the menu for the user
            System.out.println("\n=== Bank System Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();
            sc.nextLine(); // Consume newline character after input

            // Perform the corresponding action based on user choice
            switch (userChoice) {
                case 1: 
                    createAccount();
                    break;
                case 2: 
                    depositMoney();
                    break;
                case 3: 
                    withdrawMoney();
                    break;
                case 4: 
                    checkBalance();
                    break;
                case 5: 
                    viewAllAccounts();
                    break;
                case 6: 
                    System.out.println("Thank you for using the Bank System.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (userChoice != 6); // Repeat until the user chooses to exit
    }

    // Method to create a new account
    static void createAccount() {
        System.out.print("Enter Account ID: ");
        String accountId = sc.nextLine();
        
        if (bankAccounts.containsKey(accountId)) {
            System.out.println("Account already exists with this Account ID.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String holderName = sc.nextLine();
        
        double initialDeposit = 0;
        boolean validDeposit = false;

        // Validating initial deposit using switch-case
        while (!validDeposit) {
            System.out.print("Enter Initial Deposit Amount: ₹");
            initialDeposit = sc.nextDouble();
            switch (checkDepositAmount(initialDeposit)) {
                case 1:
                    validDeposit = true;
                    break;
                case 2:
                    System.out.println("Deposit amount must be positive. Please enter again.");
                    break;
                default:
                    System.out.println("Unexpected error. Please try again.");
                    break;
            }
        }

        BankAccount newAccount = new BankAccount(accountId, holderName, initialDeposit);
        bankAccounts.put(accountId, newAccount);
        System.out.println("Account created successfully.");
    }

    // Method to validate the deposit amount (used in a switch-case)
    static int checkDepositAmount(double amount) {
        if (amount > 0) {
            return 1; // Valid amount
        } else {
            return 2; // Invalid amount
        }
    }

    // Method to deposit money into an account
    static void depositMoney() {
        System.out.print("Enter Account ID: ");
        String accountId = sc.nextLine();
        BankAccount account = bankAccounts.get(accountId);
        
        if (account != null) {
            double depositAmount = 0;
            boolean validAmount = false;

            // Validate deposit amount using switch-case
            while (!validAmount) {
                System.out.print("Enter Amount to Deposit: ₹");
                depositAmount = sc.nextDouble();
                switch (checkDepositAmount(depositAmount)) {
                    case 1:
                        validAmount = true;
                        break;
                    case 2:
                        System.out.println("Deposit amount must be positive. Please enter again.");
                        break;
                    default:
                        System.out.println("Unexpected error. Please try again.");
                        break;
                }
            }

            account.depositMoney(depositAmount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    static void withdrawMoney() {
        System.out.print("Enter Account ID: ");
        String accountId = sc.nextLine();
        BankAccount account = bankAccounts.get(accountId);
        
        if (account != null) {
            double withdrawalAmount = 0;
            boolean validAmount = false;

            // Validate withdrawal amount using switch-case
            while (!validAmount) {
                System.out.print("Enter Amount to Withdraw: ₹");
                withdrawalAmount = sc.nextDouble();
                switch (checkWithdrawalAmount(account, withdrawalAmount)) {
                    case 1:
                        validAmount = true;
                        break;
                    case 2:
                        System.out.println("Withdrawal amount must be positive. Please enter again.");
                        break;
                    case 3:
                        System.out.println("Insufficient funds. Please enter a lesser amount.");
                        break;
                    default:
                        System.out.println("Unexpected error. Please try again.");
                        break;
                }
            }

            account.withdrawMoney(withdrawalAmount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to validate withdrawal amount (using switch-case)
    static int checkWithdrawalAmount(BankAccount account, double amount) {
        if (amount > 0 && amount <= account.accountBalance) {
            return 1; // Valid withdrawal
        } else if (amount <= 0) {
            return 2; // Invalid withdrawal
        } else {
            return 3; // Insufficient funds
        }
    }

    // Method to check the balance of an account
    static void checkBalance() {
        System.out.print("Enter Account ID: ");
        String accountId = sc.nextLine();
        BankAccount account = bankAccounts.get(accountId);
        
        if (account != null) {
            System.out.println("Current Balance: ₹" + account.accountBalance);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to view details of all accounts
    static void viewAllAccounts() {
        if (bankAccounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (BankAccount account : bankAccounts.values()) {
            account.displayAccountDetails();
            System.out.println("------------");
        }
    }
}
