import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    // 1. Verify adding items increases total price correctly
    @Test
    void testAddItemsIncreasesTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 200);
        cart.addItem("Pen", 50);
        assertEquals(250, cart.getTotalPrice());
    }

    // 2. Ensure removing an item decreases total price correctly
    @Test
    void testRemoveItemDecreasesTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 200);
        cart.addItem("Pen", 50);
        cart.removeItem("Pen");
        assertEquals(200, cart.getTotalPrice());
    }

    // 3. Check removing non-existent item throws exception
    @Test
    void testRemoveNonExistentItemThrowsException() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class,
                () -> cart.removeItem("Notebook"));
    }

    // 4. Verify cart handles multiple items correctly
    @Test
    void testMultipleItemsHandledCorrectly() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 50000);
        cart.addItem("Mouse", 500);
        cart.addItem("Keyboard", 1500);
        assertEquals(52000, cart.getTotalPrice());
    }

    // 5. Ensure empty cart returns total price = 0
    @Test
    void testEmptyCartTotalIsZero() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getTotalPrice());
    }
}