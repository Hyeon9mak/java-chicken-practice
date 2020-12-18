package view;

public class Display {

    private static final String NOTICE_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printNotice(String message) {
        System.out.println(NOTICE_PREFIX + message);
    }

    public static void printSelectError(){
        System.out.println(ERROR_PREFIX + "존재하지 않는 기능입니다.");
    }
}
