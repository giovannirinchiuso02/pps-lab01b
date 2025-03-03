package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {


    private static final int INITIAL_DEPOSIT = 1000;
    private static final int INITIAL_WITHDRAWAL = 200;
    private static final int WRONG_SILVER_WITHDRAWAL = 1200;
    private static final int WRONG_GOLD_WITHDRAWAL = 1600;
    private BankAccountFactory bankAccountFactory;
    private BankAccount accountSilver;
    private BankAccount accountGold;
    private BankAccount account;

    @BeforeEach
    void init() {
        this.bankAccountFactory = new BankAccountFactory();
        this.accountSilver = this.bankAccountFactory.createSilverBankAccount();
        this.accountGold = this.bankAccountFactory.createGoldBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.accountSilver.getBalance());
        assertEquals(0, this.accountGold.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.accountSilver.deposit(INITIAL_DEPOSIT);
        this.accountGold.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.accountSilver.getBalance());
        assertEquals(INITIAL_DEPOSIT, this.accountGold.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.accountSilver.deposit(INITIAL_DEPOSIT);
        this.accountGold.deposit(INITIAL_DEPOSIT);
        this.accountSilver.withdraw(INITIAL_WITHDRAWAL);
        this.accountGold.withdraw(INITIAL_WITHDRAWAL);
        assertEquals(799, this.accountSilver.getBalance());
        assertEquals(800, this.accountGold.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.accountSilver.deposit(INITIAL_DEPOSIT);
        this.accountGold.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.accountSilver.withdraw(WRONG_SILVER_WITHDRAWAL));
        assertThrows(IllegalStateException.class, () -> this.accountGold.withdraw(WRONG_GOLD_WITHDRAWAL));
    }

    @Test
    public void testCanDepositMoreThanAvailable(){
        this.accountGold.deposit(INITIAL_DEPOSIT);
        this.accountGold.withdraw(WRONG_SILVER_WITHDRAWAL);
        assertEquals(INITIAL_DEPOSIT - WRONG_SILVER_WITHDRAWAL, this.accountGold.getBalance());

    }

}
