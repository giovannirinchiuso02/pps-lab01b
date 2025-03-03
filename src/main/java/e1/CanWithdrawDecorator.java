package e1;

public class CanWithdrawDecorator extends DecoratorBankAccount {

    public CanWithdrawDecorator(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
