import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    // Calculate total price of all orders
    public double calculateTotalPrice(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getPrice)
                .sum();
    }

    // Filter orders above a given threshold
    public List<Order> filterOrdersAboveThreshold(
            List<Order> orders, double threshold) {

        return orders.stream()
                .filter(order -> order.getPrice() > threshold)
                .collect(Collectors.toList());
    }
}