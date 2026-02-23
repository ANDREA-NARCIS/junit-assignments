import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    UserRepository repository = new UserRepository();

    // 1. Verify valid user ID returns non-empty Optional
    @Test
    void testValidUserIdReturnsUser() {
        Optional<User> user = repository.findById(1);
        assertTrue(user.isPresent());
    }

    // 2. Ensure invalid user ID returns Optional.empty()
    @Test
    void testInvalidUserIdReturnsEmptyOptional() {
        Optional<User> user = repository.findById(99);
        assertTrue(user.isEmpty());
    }

    // 3. Verify get() on empty Optional throws exception
    @Test
    void testGetOnEmptyOptionalThrowsException() {
        Optional<User> user = repository.findById(99);
        assertThrows(NoSuchElementException.class, user::get);
    }

    // 4. Check orElse() returns default user
    @Test
    void testOrElseReturnsDefaultUser() {
        User defaultUser = new User(0, "Default");
        User result = repository.findById(99).orElse(defaultUser);

        assertEquals("Default", result.getName());
    }

    // 5. Ensure isPresent() works correctly
    @Test
    void testIsPresentForValidAndInvalidIds() {
        assertTrue(repository.findById(1).isPresent());
        assertFalse(repository.findById(99).isPresent());
    }
}