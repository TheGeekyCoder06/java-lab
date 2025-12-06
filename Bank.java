import java.util.Scanner;

// Base class: Account
class Account {
    String customerName;
    String accountNumber;
    String accountType;
    protected double balance;

    Account(String customerName, String accountNumber, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    // (a) Accept deposit and update balance
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // (b) Display balance
    void displayBalance() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Customer  : " + customerName);
        System.out.println("Type      : " + accountType);
        System.out.println("Balance   : " + balance);
    }
}

// Savings Account: provides compound interest & withdrawal; no cheque book
class SavAcct extends Account {

    SavAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber, "Savings");
    }

    // (c) Compute compound interest and deposit it
    // r = rate in %, n = number of years
    void computeAndDepositInterest(double rate, int years) {
        if (rate <= 0 || years <= 0) {
            System.out.println("Invalid interest data.");
            return;
        }
        double amount = balance * Math.pow((1 + rate / 100.0), years);
        double interest = amount - balance;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    // (d) Permit withdrawal and update balance
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }
    }
}

// Current Account: cheque book, min balance, no interest
class CurAcct extends Account {

    static final double MIN_BALANCE = 500.0;
    static final double SERVICE_CHARGE = 50.0;

    CurAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber, "Current");
    }

    // No interest for current account
    void computeAndDepositInterest() {
        System.out.println("No interest for current account.");
    }

    // (d) Withdraw, check minimum balance, impose penalty if needed
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Amount withdrawn: " + amount);

        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum. Service charge imposed: " 
                               + SERVICE_CHARGE);
        }
    }
}

// Demo / Bank driver
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create one savings and one current account for demo
        System.out.print("Enter name for Savings Account: ");
        String sName = sc.nextLine();
        System.out.print("Enter account number for Savings Account: ");
        String sNo = sc.nextLine();
        SavAcct sav = new SavAcct(sName, sNo);

        System.out.print("\nEnter name for Current Account: ");
        String cName = sc.nextLine();
        System.out.print("Enter account number for Current Account: ");
        String cNo = sc.nextLine();
        CurAcct cur = new CurAcct(cName, cNo);

        int choice;
        do {
            System.out.println("\n------ BANK MENU ------");
            System.out.println("1. Deposit in Savings");
            System.out.println("2. Deposit in Current");
            System.out.println("3. Display Savings Balance");
            System.out.println("4. Display Current Balance");
            System.out.println("5. Compute Interest for Savings");
            System.out.println("6. Withdraw from Savings");
            System.out.println("7. Withdraw from Current");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit (Savings): ");
                    sav.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit (Current): ");
                    cur.deposit(sc.nextDouble());
                    break;
                case 3:
                    sav.displayBalance();
                    break;
                case 4:
                    cur.displayBalance();
                    break;
                case 5:
                    System.out.print("Enter interest rate (%): ");
                    double r = sc.nextDouble();
                    System.out.print("Enter number of years: ");
                    int y = sc.nextInt();
                    sav.computeAndDepositInterest(r, y);
                    break;
                case 6:
                    System.out.print("Enter amount to withdraw (Savings): ");
                    sav.withdraw(sc.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter amount to withdraw (Current): ");
                    cur.withdraw(sc.nextDouble());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);
    }
}
