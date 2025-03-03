package e1;

public class CanWithdrawDecorator extends DecoratorBankAccount {

    private int minor_amount;

    public CanWithdrawDecorator(BankAccount bankAccount, final int minor_amount) {
        super(bankAccount);
        this.minor_amount = minor_amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount - this.getBalance() > minor_amount) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
