import game.BaseballGameRunner;
import ui.ConsoleInterface;

/**
 * @author delf
 */
public class Main {
    public static void main(String[] args) {
        new BaseballGameRunner().with(new ConsoleInterface()).run();
    }
}
