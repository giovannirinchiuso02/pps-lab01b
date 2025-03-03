package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractBankAccountTest {

    private static final int INITIAL_BALANCE = 0;
    protected static final int INITIAL_DEPOSIT = 1000;
    protected static final int INITIAL_WITHDRAWAL = 200;
    protected BankAccount bankAccount;
    protected BankAccountFactory bankAccountFactory;


    @BeforeEach
    void init() {
        bankAccountFactory = new BankAccountFactory();
        this.bankAccount = this.createBankAccount();
    }

    public abstract BankAccount createBankAccount();

    @Test
    public void testInitiallyEmpty() {
        assertEquals(INITIAL_BALANCE, this.bankAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.bankAccount.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.bankAccount.getBalance());
        assertEquals(INITIAL_DEPOSIT, this.bankAccount.getBalance());
    }



}



