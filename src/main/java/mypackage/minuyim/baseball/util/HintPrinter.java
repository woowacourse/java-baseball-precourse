package mypackage.minuyim.baseball.util;

public class HintPrinter {
    public static void printHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }
}
