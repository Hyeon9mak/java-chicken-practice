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

    public boolean isChicken(){
        return menu.isChicken();
    }

    public String getMenu() {
        return menu.getName();
    }

    public int getMenuCount() {
        return menuCount.getCount();
    }

    public int getPrice() {
        return menu.getPrice() * menuCount.getCount();
    }
}
