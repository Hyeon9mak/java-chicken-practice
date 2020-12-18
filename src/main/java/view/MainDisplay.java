package view;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MainDisplay extends Display {

    private static final String DISPLAY_NAME = "메인화면";

    public static void loadMenu() {
        MainMenu selectedMenu = null;
        while (selectedMenu != MainMenu.QUIT) {
            printMenu();
            selectedMenu = selectMenu();
            selectedMenu.executeMenu();
        }
    }

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(MainMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    private static MainMenu selectMenu() {
        while (true) {
            try {
                return MainMenu.getMenuByInput(InputView.inputSelectMenu());
            } catch (NoSuchElementException e) {
                printSelectError();
            }
        }
    }
}
