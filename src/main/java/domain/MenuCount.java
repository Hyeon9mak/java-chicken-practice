package domain;

public class MenuCount {

    private static final int MINIMUM_COUNT = 1;
    private static final int MAXIMUM_COUNT = 99;

    private final int count;

    private MenuCount(final int count) {
        validateRange(count);
        this.count = count;
    }

    public static MenuCount newCount(final int count) {
        return new MenuCount(count);
    }

    private void validateRange(int count) {
        if (count < MINIMUM_COUNT || MAXIMUM_COUNT < count) {
            throw new IllegalArgumentException("한 번에 주문 가능한 메뉴 수량은 1~99개 입니다.");
        }
    }

}
