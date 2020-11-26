package baseball.view;

import static baseball.domain.RandomNumbers.LIST_SIZE;

public class OutputView {
    public static final int NOTHING = 0;

    public static void printResult(int balls, int strikes) {
        if (balls == NOTHING && strikes == NOTHING) System.out.println("낫싱");
        else if (strikes == LIST_SIZE) {
            System.out.println(strikes + "스트라이크");
            System.out.println(strikes + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if (balls == NOTHING) System.out.println(strikes + "스트라이크");
        else if (strikes == NOTHING) System.out.println(balls + "볼");
        else System.out.println(balls + "볼 " + strikes + "스트라이크");
    }

    public static void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
