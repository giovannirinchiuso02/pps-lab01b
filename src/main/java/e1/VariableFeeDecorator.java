package e1;

public class VariableFeeDecorator extends DecoratorBankAccount{

    private int fee;
    private static final int BRONZE_AMOUNT_LIMIT_TO_PAY_FEE = 100;

    public VariableFeeDecorator(BankAccount bankAccount, final int fee) {
        super(bankAccount);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        if (amount > BRONZE_AMOUNT_LIMIT_TO_PAY_FEE) {
            super.withdraw(amount + this.fee);
        }
        else {
            super.withdraw(amount);
        }
    }
}
