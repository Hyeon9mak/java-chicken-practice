import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import view.InputView;
import view.MainDisplay;
import view.MainMenu;
import view.OutputView;

public class ChickenPOS {

    private ChickenPOS(){
    }

    public static ChickenPOS newChickenPOS() {
        return new ChickenPOS();
    }

    public void start() {
        MainDisplay.loadMenu();


        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
