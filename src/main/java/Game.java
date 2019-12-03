/**
 * java-baseball-precourse
 * Game.java
 * Purpose: 게임 그 자체.
 *
 * @version 1.0.0
 * @author MinKyu, Song.
 */

import utils.InputUtils;

public class Game {
    static final int RETRY = 1;
    static final int EXIT = 2;
    static final String RETRYPROMPTFORMAT = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    /**
     * 프로젝트 전체의 Main method, 정해진 게임을 실행시킨.
     *
     * @param args, 사용되지 않는다.
     */
    public static void main(String[] args) {
        do {
            new BaseballGame().run();
        } while (askRetry());
        InputUtils.closeInput();
    }

    /**
     * 다시 게임을 실행할지 물어본다.
     *
     * @return 재실행 유무
     */
    static boolean askRetry() {
        boolean result = false;
        while (true) {
            int input = InputUtils.inputInteger(
                    String.format(RETRYPROMPTFORMAT, RETRY, EXIT));
            if (input == RETRY || input == EXIT) {
                result = input == RETRY;
                break;
            } else {
                System.out.println(InputUtils.INVALID);
            }
        }
        return result;
    }
}