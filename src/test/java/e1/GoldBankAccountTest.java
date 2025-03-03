package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends AbstractBankAccountTest{

    private static final int RED_WITHDRAWAL_IN_LIMIT = 1200;
    protected static final int WRONG_GOLD_WITHDRAWAL = 1600;

    @Override
    public BankAccount createBankAccount() {
        return super.bankAccountFactory.createGoldBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        super.bankAccount.withdraw(INITIAL_WITHDRAWAL);
        assertEquals(INITIAL_DEPOSIT - INITIAL_WITHDRAWAL, super.bankAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> super.bankAccount.withdraw(WRONG_GOLD_WITHDRAWAL));
    }

    @Test
    public void testCanWithdrawMoreThanAvailableInLimit(){
        super.bankAccount.deposit(INITIAL_DEPOSIT);
        super.bankAccount.withdraw(RED_WITHDRAWAL_IN_LIMIT);
        assertEquals(INITIAL_DEPOSIT - RED_WITHDRAWAL_IN_LIMIT, this.bankAccount.getBalance());

    }
}
