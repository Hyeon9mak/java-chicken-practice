package domain;

public class Order {

    private final Menu menu;
    private final MenuCount menuCount;

    private Order(Menu menu, MenuCount menuCount) {
        this.menu = menu;
        this.menuCount = menuCount;
    }

    public static Order newOrder(Menu menu, MenuCount menuCount) {
        return new Order(menu, menuCount);
    }
}
