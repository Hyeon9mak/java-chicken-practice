package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static final List<Order> orders = new ArrayList<>();

    public static void addOrder(Order order){
        orders.add(order);
    }
}
