package e1;

import org.junit.jupiter.api.Test;

import static e1.BankAccountFactory.SILVER_FEE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends AbstractBankAccountTest{

    protected static final int WRONG_SILVER_WITHDRAWAL = 1200;

    @Override
    public BankAccount createBankAccount() {
        return super.bankAccountFactory.createSilverBankAccount();
    }


    @Test
    public void testCanWithdraw() {
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        super.bankAccount.withdraw(INITIAL_WITHDRAWAL);
        assertEquals(INITIAL_DEPOSIT - (INITIAL_WITHDRAWAL + SILVER_FEE) , this.bankAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.bankAccount.withdraw(WRONG_SILVER_WITHDRAWAL));
    }
}
