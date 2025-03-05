package e1;

public class CanWithdrawDecorator extends DecoratorBankAccount {

    private final int minor_amount;

    public CanWithdrawDecorator(final BankAccount bankAccount, final int minor_amount) {
        super(bankAccount);
        this.minor_amount = minor_amount;
    }

    @Override
    public void withdraw(final int amount) {
        if (amount - this.getBalance() > minor_amount) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
