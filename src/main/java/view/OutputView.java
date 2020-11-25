package view;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public static void printInputNumber() {
        System.out.print(NEW_LINE + "숫자를 입력해주세요 : ");
    }

    public static void printResultBallCount(int ball) {
        System.out.print(ball + "볼 ");
    }

    public static void printResultStrikeCount(int strike) {
        System.out.print(strike + "스트라이크");
    }

    public static void printResultNothing() {
        System.out.print("낫싱");
    }
    
    public static void printGameEnd() {
        System.out.println(NEW_LINE + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
