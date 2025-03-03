package e1;

public interface BankAccount {

    public int getBalance();

    public void deposit(final int amount);

    public void withdraw(final int amount);
}