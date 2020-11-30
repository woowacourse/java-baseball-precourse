package baseball;

import java.util.Scanner;

public class GameResetter {
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private GameResetter() {
    }

    public static void printFinishMessage() {
        System.out.println(FINISH_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }
}
