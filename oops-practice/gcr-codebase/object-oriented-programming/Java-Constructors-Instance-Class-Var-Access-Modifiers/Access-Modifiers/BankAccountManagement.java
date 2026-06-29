// Section 3 – Problem 3: Bank Account Management
// Demonstrates: public accountNumber, protected accountHolder, private balance

class BankAccount {
    public    int    accountNumber;   // accessible everywhere
    protected String accountHolder;   // accessible in same package + subclasses
    private   double balance;         // accessible only within BankAccount

    BankAccount(int accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance       = initialBalance;
    }

    // Public getter for private balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs." + amount
                             + " | New Balance: Rs." + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Public method to withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount
                             + " | Remaining Balance: Rs." + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public void display() {
        System.out.println("Account No: " + accountNumber
                         + " | Holder: " + accountHolder
                         + " | Balance: Rs." + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;   // annual interest rate in %

    SavingsAccount(int accountNumber, String accountHolder,
                   double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Add yearly interest to balance
    void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest at " + interestRate + "% added: Rs." + interest);
    }

    @Override
    public void display() {
        // accountNumber → public    : directly accessible ✓
        // accountHolder → protected : accessible in subclass ✓
        // balance       → private   : NOT directly accessible, use getBalance() ✓
        System.out.println("Savings Account"
                         + " | No: " + accountNumber
                         + " | Holder: " + accountHolder
                         + " | Balance: Rs." + getBalance()
                         + " | Rate: " + interestRate + "%");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        System.out.println("-- Bank Account --");
        BankAccount acc = new BankAccount(100001, "Meera Nair", 25000.0);
        acc.display();
        acc.deposit(5000.0);
        acc.withdraw(3000.0);
        acc.withdraw(50000.0);   // should fail – insufficient funds
        acc.display();

        System.out.println("\n-- Savings Account (subclass) --");
        SavingsAccount savings = new SavingsAccount(
                200001, "Rajan Pillai", 50000.0, 4.5);
        savings.display();
        savings.addInterest();
        savings.display();
    }
}
