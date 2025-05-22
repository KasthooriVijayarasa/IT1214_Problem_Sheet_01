class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int numAccounts;

    public Bank() {
        accounts = new BankAccount[5];
        numAccounts = 0;
    }

    public void addAccount(BankAccount account) {
        if (numAccounts < 5) {
            accounts[numAccounts] = account;
            numAccounts++;
        } else {
            System.out.println("Bank is at full capacity for accounts.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        boolean found = false;
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                found = true;
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful. New balance: " + accounts[i].getBalance());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Account with number " + accountNumber + " not found.");
        }
    }

    public void displayAllAccounts() {
        System.out.println("Account \tHolder\t\tBalance");
        System.out.println("----------------------------------------");
        for (int i = 0; i < numAccounts; i++) {
            System.out.println(accounts[i].getAccountNumber() + "\t\t"+ accounts[i].getAccountHolder() + "\t\t" + accounts[i].getBalance());
        }
    }
}

public class BankManager {
    public static void main(String[] args) {
        Bank bank = new Bank();
    
        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));
        
        bank.withdrawFromAccount(1001, 6000.0); 
        bank.withdrawFromAccount(1002, 1000.0); 
        
        bank.displayAllAccounts();
    }
}