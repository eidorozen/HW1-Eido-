public class BasicAccount implements IAccount {

    private int accountNumber;
    private double balance;
    private double withdrawLimit;

    public BasicAccount(int accountNumber, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.withdrawLimit = withdrawLimit;
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

        if (allowedAmount > withdrawLimit) {
            allowedAmount = withdrawLimit;
        }

        if (balance - allowedAmount < 0) {
            allowedAmount = balance;
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
