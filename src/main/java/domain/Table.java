package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final int number;
    private final List<Order> orders = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isEqualTableNumber(int number) {
        return this.number == number;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean isOrdersEmpty() {
        return orders.isEmpty();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
