package e1;

public class DecoratorBankAccount implements BankAccount {

    private final BankAccount bankAccount;

    public DecoratorBankAccount(final BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        bankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        bankAccount.withdraw(amount);
    }


}
