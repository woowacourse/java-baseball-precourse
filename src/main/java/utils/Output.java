package utils;

public class Output {

    public static void printBallAndStrike(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
