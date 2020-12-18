package view;

import java.util.Scanner;

public class InputView extends Display {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTableNumber() {
        printNotice("주문할 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String getSelectMenu() {
        printNotice("원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }
}
