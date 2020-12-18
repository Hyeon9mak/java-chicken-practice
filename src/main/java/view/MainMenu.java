package view;

import java.util.Arrays;
import java.util.function.Consumer;
import service.OrderService;
import service.PaymentService;

public enum MainMenu {
    ORDER("1", "주문등록", (key) -> OrderService.order()),
    PAYMENT("2", "결제하기", (key) -> PaymentService.payment()),
    QUIT("3", "프로그램종료", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    MainMenu(final String key, final String name, final Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public static MainMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(mainMenu
            -> mainMenu.key.equals(input))
            .findAny()
            .get();
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void executeMenu() {
        select.accept(key);
    }
}
