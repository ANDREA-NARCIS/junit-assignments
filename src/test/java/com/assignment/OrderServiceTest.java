import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService service = new OrderService();

    // 1. Verify total price calculation
    @Test
    void testTotalPriceCalculation() {
        List<Order> orders = List.of(
                new Order(100),
                new Order(200),
                new Order(300)
        );

        assertEquals(600, service.calculateTotalPrice(orders));
    }

    // 2. Ensure orders above threshold are filtered correctly
    @Test
    void testFilterOrdersAboveThreshold() {
        List<Order> orders = List.of(
                new Order(100),
                new Order(500),
                new Order(1000)
        );

        List<Order> result =
                service.filterOrdersAboveThreshold(orders, 400);

        assertEquals(2, result.size());
    }

    // 3. Verify behavior when no orders exist
    @Test
    void testNoOrdersExist() {
        List<Order> orders = List.of();

        assertEquals(0, service.calculateTotalPrice(orders));
        assertTrue(service.filterOrdersAboveThreshold(orders, 100).isEmpty());
    }

    // 4. Check multiple orders aggregation
    @Test
    void testMultipleOrdersAggregatedCorrectly() {
        List<Order> orders = List.of(
                new Order(50),
                new Order(150),
                new Order(300)
        );

        assertEquals(500, service.calculateTotalPrice(orders));
    }

    // 5. Ensure negative order values handled properly
    @Test
    void testNegativeOrderValueThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Order(-100));
    }
}