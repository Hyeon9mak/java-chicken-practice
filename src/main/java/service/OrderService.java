package service;

import domain.Menu;
import domain.Table;

public class OrderService {

    public static void order() {
        Table table = TableService.selectTableByOrder();
        //Menu menu = MenuService.selectMenuByOrder();
    }
}
