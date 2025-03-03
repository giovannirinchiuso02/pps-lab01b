package e1;

public class BankAccountFactory {
    private static final int SILVER_FEE = 1;
    private static final int SILVER_MINOR_AMOUNT = 0;

    public BankAccount createSilverBankAccount() {
        return new DecoratorBankAccount(new FeeDecorator(new CanWithdrawDecorator(new CoreBankAccount(), SILVER_MINOR_AMOUNT), SILVER_FEE));
    }





}
