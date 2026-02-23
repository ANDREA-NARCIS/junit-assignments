import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    // 1. Verify that a valid password passes validation
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Password@1"));
    }

    // 2. Ensure password shorter than 8 characters fails
    @Test
    void testShortPasswordFails() {
        assertFalse(validator.isValid("Ab@1"));
    }

    // 3. Ensure password without uppercase fails
    @Test
    void testNoUppercaseFails() {
        assertFalse(validator.isValid("password@1"));
    }

    // 4. Ensure password without digits fails
    @Test
    void testNoDigitFails() {
        assertFalse(validator.isValid("Password@"));
    }

    // 5. Ensure password without special characters fails
    @Test
    void testNoSpecialCharacterFails() {
        assertFalse(validator.isValid("Password1"));
    }
}