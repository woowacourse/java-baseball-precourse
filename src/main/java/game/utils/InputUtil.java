
/*
 * InputUtil.java
 * @author crystal_rim
 * @version 1.0.0
 * @date 2019-12-02
 */
package game.utils;

import java.util.Scanner;

public class InputUtil {
    private static final String NUMBERS_REQUIREMENT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String REPLAY_REQUIREMENT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /**
     * This method is used to receive numbers from users.
     * @return String This returns input value.
     */
    public static String inputNumbers() {
        System.out.print(NUMBERS_REQUIREMENT_MESSAGE);
        return new Scanner(System.in).nextLine();
    }

    /**
     * This method is used to receive intention of replay from users.
     * @return int
     */
    public static int inputIntentionOfReplay() {
        System.out.println(REPLAY_REQUIREMENT_MESSAGE);
        return new Scanner(System.in).nextInt();
    }
}
