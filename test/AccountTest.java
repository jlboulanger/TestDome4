import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositCannotPassNegativeValue() {
        Account account = new Account(-20);
        assertFalse(account.deposit(-1.0));
    }

    @Test
    public void withdrawCannotPassNegativeValue() {
        Account account = new Account(-20);
        assertFalse(account.withdraw(-1.0));
    }

    @Test
    public void accountCannotOverstepLimit() {
        Account account = new Account(-20);
        account.deposit(10);
        assertFalse(account.withdraw(40d));
    }

    @Test
    public void depositCorrectAmount() {
        Account account = new Account(-20);
        assertTrue(account.deposit(10d));
        assertTrue(account.deposit(20d));
        assertEquals(30d, account.getBalance(), epsilon);
    }

    @Test
    public void withdrawCorrectAmount() {
        Account account = new Account(-20);
        assertTrue(account.deposit(20d));
        assertTrue(account.withdraw(5d));
        assertEquals(15d, account.getBalance(), epsilon);
    }

    @Test
    public void equalsInteger() {
        Integer i1 = 127;
        Integer i2 = 127;
        assertTrue(i1 == i2);
        Integer i3 = 128;
        Integer i4 = 128;
        assertFalse(i3 == i4);
    }
}
