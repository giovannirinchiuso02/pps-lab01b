package e1;

public class FeeDecorator extends DecoratorBankAccount{

    private int fee = 1;

    public FeeDecorator(BankAccount bankAccount, final int fee) {
        super(bankAccount);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + this.fee);
    }
}
