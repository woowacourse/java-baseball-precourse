package baseball;

public class Output {
    public static void printResult(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if (strike != 0 && ball != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        else if (strike != 0) {
            System.out.printf("%d스트라이크\n", strike);
        }
        else if (ball != 0) {
            System.out.printf("%d볼\n", ball);
        }
    }
}
