package e1;

public class FeeDecorator extends DecoratorBankAccount{

    private static final int FEE = 1;

    public FeeDecorator(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + FEE);
    }
}
