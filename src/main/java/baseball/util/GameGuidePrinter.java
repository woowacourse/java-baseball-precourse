package baseball.util;

public class GameGuidePrinter {

    public static void inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void gameStartAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void gameFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void gameResult(String gameResult) {
        System.out.println(gameResult);
    }
}
