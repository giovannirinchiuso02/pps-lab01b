package e1;

import org.junit.jupiter.api.Test;

import static e1.BankAccountFactory.SILVER_FEE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest{

    private static final int SMALL_WITHDRAW_BRONZE = 50;
    @Override
    public BankAccount createBankAccount() {
        return super.bankAccountFactory.createBronzeBankAccount();
    }

    @Test
    void testWithdrawWithFee() {
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        super.bankAccount.withdraw(INITIAL_WITHDRAWAL);
        assertEquals(INITIAL_DEPOSIT - INITIAL_WITHDRAWAL - SILVER_FEE, super.bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithoutFee() {
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        super.bankAccount.withdraw(SMALL_WITHDRAW_BRONZE);
        assertEquals(INITIAL_DEPOSIT - SMALL_WITHDRAW_BRONZE, super.bankAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.bankAccount.withdraw(SilverBankAccountTest.WRONG_SILVER_WITHDRAWAL));
    }

}
