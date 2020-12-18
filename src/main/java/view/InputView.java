package view;

import java.util.Scanner;

public class InputView extends Display {

    private static final String REQUEST_INPUT_SELECT_MENU = "원하는 기능을 선택하세요.";
    private static final String REQUEST_INPUT_TABLE_NUMBER = "주문할 테이블을 선택하세요.";
    private static final String REQUEST_INPUT_MENU_NUMBER = "등록할 메뉴를 선택하세요.";
    private static final String REQUEST_INPUT_MENU_COUNT = "메뉴의 수량을 입력하세요.";
    private static final String REQUEST_SELECT_PAYMENT = "신용 카드는 1번, 현금은 2번";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputSelectMenu() {
        printNotice(REQUEST_INPUT_SELECT_MENU);
        return scanner.nextLine();
    }

    public static String inputTableNumber() {
        printNotice(REQUEST_INPUT_TABLE_NUMBER);
        return scanner.nextLine();
    }

    public static String inputMenuNumber() {
        printNotice(REQUEST_INPUT_MENU_NUMBER);
        return scanner.nextLine();
    }

    public static String inputMenuCount() {
        printNotice(REQUEST_INPUT_MENU_COUNT);
        return scanner.nextLine();
    }

    public static String inputSelectPayment() {
        printNotice(REQUEST_SELECT_PAYMENT);
        return scanner.nextLine();
    }
}
