public class StandardAccount implements IAccount {

    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0;

        if (creditLimit < 0) {
            this.creditLimit = creditLimit;
        } else {
            this.creditLimit = 0;
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) {
            return 0;
        }

        double allowedAmount = amount;

        if (balance - allowedAmount < creditLimit) {
            allowedAmount = balance - creditLimit;
        }

        if (allowedAmount < 0) {
            return 0;
        }

        balance -= allowedAmount;
        return allowedAmount;
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}
