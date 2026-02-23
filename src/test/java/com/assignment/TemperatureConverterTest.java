import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    // 1. Verify Celsius → Fahrenheit for known values
    @Test
    void testCelsiusToFahrenheitKnownValues() {
        assertEquals(32, converter.celsiusToFahrenheit(0));
        assertEquals(212, converter.celsiusToFahrenheit(100));
    }

    // 2. Verify Fahrenheit → Celsius for known values
    @Test
    void testFahrenheitToCelsiusKnownValues() {
        assertEquals(0, converter.fahrenheitToCelsius(32));
        assertEquals(100, converter.fahrenheitToCelsius(212));
    }

    // 3. Ensure negative Celsius values convert correctly
    @Test
    void testNegativeCelsiusConversion() {
        assertEquals(14, converter.celsiusToFahrenheit(-10));
    }

    // 4. Ensure large Fahrenheit values convert correctly
    @Test
    void testLargeFahrenheitConversion() {
        assertEquals(537.78, converter.fahrenheitToCelsius(1000), 0.01);
    }

    // 5. Verify 0°C equals 32°F
    @Test
    void testZeroCelsiusEqualsThirtyTwoFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0));
    }
}