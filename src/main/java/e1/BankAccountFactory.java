package e1;

public class BankAccountFactory {
    private static final int SILVER_FEE = 1;
    private static final int GOLD_FEE = 0;
    private static final int SILVER_MINOR_AMOUNT = 0;
    private static final int GOLD_MINOR_AMOUNT = 500;

    public BankAccount createSilverBankAccount() {
        return new DecoratorBankAccount(new FeeDecorator(new CanWithdrawDecorator(new CoreBankAccount(), SILVER_MINOR_AMOUNT), SILVER_FEE));
    }

    public BankAccount createGoldBankAccount() {
        return new DecoratorBankAccount(new FeeDecorator(new CanWithdrawDecorator(new CoreBankAccount(), GOLD_MINOR_AMOUNT), GOLD_FEE));
    }







}
