package e1;

public class CanWithdrawDecorator extends DecoratorBankAccount {

    private final int minorAmount;

    public CanWithdrawDecorator(final BankAccount bankAccount, final int minorAmount) {
        super(bankAccount);
        this.minorAmount = minorAmount;
    }

    @Override
    public void withdraw(final int amount) {
        if (amount - this.getBalance() > this.minorAmount) {
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
