package service;

import domain.Menu;
import domain.MenuRepository;
import java.util.NoSuchElementException;
import view.InputView;
import view.OutputView;

public class MenuService {

    public static Menu selectMenuByOrder() {
        while (true) {
            try {
                OutputView.printMenus(MenuRepository.menus());
                return findMenuByNumber(getNumberByInput());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static int getNumberByInput() {
        try {
            return Integer.parseInt(InputView.inputMenuNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("화면에 보이는 메뉴 번호를 선택해 주세요.");
        }
    }

    private static Menu findMenuByNumber(int number) {
        try {
            return MenuRepository.menus().stream()
                .filter(menu -> menu.isEqualMenuNumber(number))
                .findAny()
                .get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("화면에 보이는 메뉴 번호를 선택해 주세요.");
        }
    }


}
