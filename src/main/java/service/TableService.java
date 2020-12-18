package service;

import domain.Table;
import domain.TableRepository;
import java.util.NoSuchElementException;
import view.InputView;
import view.OutputView;

public class TableService {

    public static Table selectTableByOrder() {
        while (true) {
            try {
                OutputView.printTables(TableRepository.tables());
                final int number = getTablWithValidate();
                return findTableByNumber(number);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static int getTablWithValidate() {
        try {
            return Integer.parseInt(InputView.getSelectMenu());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("화면에 보이는 테이블 번호를 선택해 주세요.");
        }
    }

    private static Table findTableByNumber(int number) {
        try {
            return TableRepository.tables().stream()
                .filter(table -> table.isEqualTableNumber(number))
                .findAny()
                .get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("화면에 보이는 테이블 번호를 선택해 주세요.");
        }
    }
}