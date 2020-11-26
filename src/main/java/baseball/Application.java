package baseball;

import controller.BaseballGameController;
import java.util.Scanner;

/**
 * @author yhh1056
 * @since 2020/11/26
 */
public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BaseballGameController baseballGameController = new BaseballGameController(scanner);
        baseballGameController.play();
    }
}
