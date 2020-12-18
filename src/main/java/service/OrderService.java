package service;

import domain.MenuCount;
import domain.Menu;
import domain.Order;
import domain.OrderRepository;
import domain.Table;

public class OrderService {

    public static void order() {
        Table table = TableService.selectTable();
        Menu menu = MenuService.selectMenuByOrder();
        MenuCount menuCount = MenuService.selectCountByOrder();
        Order order = Order.newOrder(menu, menuCount);
        table.addOrder(order);
        OrderRepository.addOrder(order);
    }
}
