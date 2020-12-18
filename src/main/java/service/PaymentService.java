package service;

import domain.Table;
import java.util.NoSuchElementException;
import view.InputView;
import view.PaymentDisplay;
import view.PaymentMenu;

public class PaymentService {

    private static Table table;
    private static int totalPrice;

    public static void payment() {
        PaymentService.table = TableService.selectTable();
        PaymentDisplay.printOrdersOfTable(table);
        PaymentDisplay.printPaymentOfTable(table);
        PaymentMenu payment = selectPayment();
        payment.execute();
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
        PaymentService.table.getOrders()
            .stream()
            .forEach(order -> totalPrice += order.getPrice());
        PaymentDisplay.printTotalPrice(totalPrice);
    }

    public static void cash() {
        PaymentService.table.getOrders()
            .stream()
            .forEach(order -> totalPrice += order.getPrice());
        PaymentDisplay.printTotalPrice(totalPrice);
    }
}
