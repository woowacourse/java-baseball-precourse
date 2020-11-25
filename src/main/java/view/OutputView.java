package view;

public class OutputView {
    public static void printInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void printResultBallCount(int ball) {
        System.out.print(ball + "볼");
    }

    public static void printResultStrikeCount(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void printResultNothing() {
        System.out.println("낫싱");
    }
}
