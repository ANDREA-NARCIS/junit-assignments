import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    // 1. Verify initial balance is set correctly
    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount(1000);
        assertEquals(1000, account.getBalance());
    }

    // 2. Check depositing valid amount increases balance
    @Test
    void testDepositValidAmount() {
        BankAccount account = new BankAccount(500);
        account.deposit(300);
        assertEquals(800, account.getBalance());
    }

    // 3. Ensure depositing negative amount throws exception
    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(500);
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));
    }

    // 4. Verify withdrawing valid amount decreases balance
    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    // 5. Ensure withdrawing more than balance throws exception
    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount(300);
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(500));
    }
}