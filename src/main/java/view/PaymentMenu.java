package view;

import java.util.Arrays;
import java.util.function.Consumer;
import service.OrderService;
import service.PaymentService;

public enum PaymentMenu {
    CARD("1", "카드", (key) -> PaymentService.card()),
    CASH("2", "현금", (key) -> PaymentService.cash());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    PaymentMenu(final String key, final String name, final Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    public static PaymentMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(paymentMenu
            -> paymentMenu.key.equals(input))
            .findAny()
            .get();
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        select.accept(key);
    }
}
