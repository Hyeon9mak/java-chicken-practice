package domain;

public class Order {

    private final Menu menu;
    private final int count;

    private Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order newOrder(Menu menu, int count) {
        return new Order(menu, count);
    }
}
