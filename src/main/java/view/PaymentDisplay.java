package view;

import domain.Table;

public class PaymentDisplay extends Display {

    public static void printOrdersOfTable(Table table) {
        printNotice("주문 내역");
        System.out.println("메뉴\t수량\t금액");
        table.getOrders().stream().forEach(order ->
            System.out.println(order.getMenu()
                + "\t" + order.getMenuCount()
                + "\t" + order.getPrice())
        );
        System.out.println();
    }

    public static void printPaymentOfTable(Table table) {
        System.out.printf("%s번 테이블의 결제를 진행합니다.\n", table.toString());
    }

    public static void printPaymentError() {
        System.out.println("신용카드와 현금 중 선택해주세요.");
    }

    public static void printTotalPrice(int totalPrice) {
        printNotice("최종 결제할 금액");
        System.out.printf("%d원", totalPrice);
        System.out.println();
    }
}
