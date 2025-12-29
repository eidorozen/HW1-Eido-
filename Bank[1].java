import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void openAccount(IAccount account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    public void closeAccount(int accountNumber) {
        IAccount toRemove = null;

        for (IAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                if (account.getCurrentBalance() >= 0) {
                    toRemove = account;
                } else {
                    System.out.println("Account not closed due to debt");
                }
                break;
            }
        }

        if (toRemove != null) {
            accounts.remove(toRemove);
        }
    }

    public List<IAccount> getAllAccounts() {
        return accounts;
    }

    public List<IAccount> getAllAccountsInDebt() {
        List<IAccount> result = new ArrayList<>();

        for (IAccount account : accounts) {
            if (account.getCurrentBalance() < 0) {
                result.add(account);
            }
        }

        return result;
    }

    public List<IAccount> getAllAccountsWithBalance(double amount) {
        List<IAccount> result = new ArrayList<>();

        for (IAccount account : accounts) {
            if (account.getCurrentBalance() > amount) {
                result.add(account);
            }
        }

        return result;
    }
}
