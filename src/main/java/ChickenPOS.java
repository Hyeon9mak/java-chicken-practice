import view.MainDisplay;

public class ChickenPOS {

    private ChickenPOS() {
    }

    public static ChickenPOS newChickenPOS() {
        return new ChickenPOS();
    }

    public void start() {
        MainDisplay.loadMenu();
    }
}
