package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount accountSilver;
    private BankAccount accountGold;

    @BeforeEach
    void init(){
        this.accountSilver = new DecoratorBankAccount(new SilverBankAccount());
        this.accountGold = new GoldBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.accountSilver.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.accountSilver.deposit(1000);
        assertEquals(1000, this.accountSilver.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.accountSilver.deposit(1000);
        this.accountSilver.withdraw(200);
        assertEquals(799, this.accountSilver.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.accountSilver.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.accountSilver.withdraw(1200));
    }

}
