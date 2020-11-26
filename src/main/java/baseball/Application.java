/*
 * @(#)Application.java
 *
 */

package baseball;

import java.util.Scanner;
import utils.RandomUtils;

public class Application {
    static Run run = new Run();

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String command = null;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            command = scanner.next();
            if (command.equals(Constants.EXIT_GAME)) {
                System.out.println("게임 종료");
                scanner.close();
                break;
            }

            run.Run();
        }
    }
}
