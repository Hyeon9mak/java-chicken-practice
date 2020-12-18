package service;

import domain.Order;
import domain.Table;
import java.util.List;
import java.util.NoSuchElementException;
import view.InputView;
import view.PaymentDisplay;
import view.PaymentMenu;

public class PaymentService {

    private static final double DISCOUNT_CASH = 0.95;
    private static final int DISCOUNT_RULE = 10;
    private static final int DISCOUNT_PRICE = 10_000;

    private static Table table;

    public static void payment() {
        PaymentService.table = TableService.selectTable();
        PaymentDisplay.printOrdersOfTable(table);
        PaymentDisplay.printPaymentOfTable(table);
        PaymentMenu payment = selectPayment();
        payment.execute();
        table.clear();
    }

    private static PaymentMenu selectPayment() {
        while (true) {
            try {
                return PaymentMenu.getMenuByInput(InputView.inputSelectPayment());
            } catch (NoSuchElementException e) {
                PaymentDisplay.printPaymentError();
            }
        }
    }

    public static void card() {
        List<Order> orders = PaymentService.table.getOrders();
        int checkPrice = calculateChickenPrice(orders);
        int beveragePrice = calculateBeveragePrice(orders);
        int totalPrice = checkPrice + beveragePrice;
        PaymentDisplay.printTotalPrice(totalPrice);
    }

    public static void cash() {
        List<Order> orders = PaymentService.table.getOrders();
        int checkPrice = calculateChickenPrice(orders);
        int beveragePrice = calculateBeveragePrice(orders);
        int totalPrice = (int)((checkPrice + beveragePrice) * DISCOUNT_CASH);
        PaymentDisplay.printTotalPrice(totalPrice);
    }

    private static int calculateChickenPrice(List<Order> orders) {
        int totalChickenPrice = getTotalChicekPrice(orders);
        int chickenCount = getTotalChickenCount(orders);
        return totalChickenPrice - ((chickenCount / DISCOUNT_RULE) * DISCOUNT_PRICE);
    }

    private static int getTotalChickenCount(List<Order> orders) {
        return orders.stream()
            .filter(Order::isChicken)
            .mapToInt(Order::getMenuCount)
            .sum();
    }

    private static int getTotalChicekPrice(List<Order> orders) {
        return orders.stream()
            .filter(Order::isChicken)
            .mapToInt(Order::getPrice)
            .sum();
    }

    private static int calculateBeveragePrice(List<Order> orders) {
        return getTotalBeveragePrice(orders);
    }

    private static int getTotalBeveragePrice(List<Order> orders) {
        return orders.stream()
            .filter(order -> !order.isChicken())
            .mapToInt(Order::getPrice)
            .sum();
    }
}
