package service;

import domain.MenuCount;
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

    public static MenuCount selectCountByOrder() {
        while (true) {
            try {
                return MenuCount.newCount(getCountByInput());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static int getCountByInput() {
        try{
            return Integer.parseInt(InputView.inputMenuCount());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수량은 정수 값으로만 입력 가능합니다.");
        }
    }
}
