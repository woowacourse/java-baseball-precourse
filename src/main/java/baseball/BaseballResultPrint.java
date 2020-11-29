package baseball;

public class BaseballResultPrint {
    public static void resultPrint(BaseballCounterResult baseballCounterResult) {

        if (baseballCounterResult.getBall() > 0) {
            System.out.printf("%d볼 ", baseballCounterResult.getBall());
        }
        if (baseballCounterResult.getStrike() > 0) {
            System.out.printf("%d스트라이크", baseballCounterResult.getStrike());
        }
        if (baseballCounterResult.getBall() == 0 && baseballCounterResult.getStrike() == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();
        if (baseballCounterResult.getStrike() == 3) {
            System.out.println(baseballCounterResult.getStrike() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
