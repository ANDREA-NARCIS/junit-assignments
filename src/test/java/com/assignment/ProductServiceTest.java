import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    ProductService service = new ProductService();

    // 1. Verify 10% discount is applied correctly
    @Test
    void testTenPercentDiscount() {
        Product product = new Product("Book", 100);
        Function<Product, Double> discount10 =
                p -> p.getPrice() * 0.90;

        double finalPrice = service.applyDiscount(product, discount10);

        assertEquals(90, finalPrice);
    }

    // 2. Ensure 0% discount returns original price
    @Test
    void testZeroPercentDiscount() {
        Product product = new Product("Pen", 50);
        Function<Product, Double> noDiscount =
                p -> p.getPrice();

        double finalPrice = service.applyDiscount(product, noDiscount);

        assertEquals(50, finalPrice);
    }

    // 3. Verify negative price throws exception
    @Test
    void testNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Invalid", -10));
    }

    // 4. Check multiple products discounted using Streams
    @Test
    void testMultipleProductsDiscounted() {
        List<Product> products = List.of(
                new Product("Item1", 100),
                new Product("Item2", 200)
        );

        Function<Product, Double> discount10 =
                p -> p.getPrice() * 0.90;

        List<Double> prices =
                service.applyDiscountToProducts(products, discount10);

        assertEquals(List.of(90.0, 180.0), prices);
    }

    // 5. Ensure discount function can be swapped dynamically
    @Test
    void testDynamicDiscountFunction() {
        Product product = new Product("Laptop", 1000);

        Function<Product, Double> discount10 =
                p -> p.getPrice() * 0.90;
        Function<Product, Double> discount20 =
                p -> p.getPrice() * 0.80;

        assertEquals(900, service.applyDiscount(product, discount10));
        assertEquals(800, service.applyDiscount(product, discount20));
    }
}