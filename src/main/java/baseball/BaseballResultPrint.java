package baseball;

public class BaseballResultPrint {
    public static void resultPrint(BaseballCounterResult baseballCounterResult) {

        if (1 <= baseballCounterResult.getBall() && 1 <= baseballCounterResult.getStrike()) {
            System.out.println(String.format("%d볼 %d스트라이크 입니다.", baseballCounterResult.getBall(), baseballCounterResult.getStrike()));
        } else if (1 <= baseballCounterResult.getBall() && baseballCounterResult.getStrike() == 0) {
            System.out.println(baseballCounterResult.getBall() + "볼 입니다.");
        } else if (0 == baseballCounterResult.getBall() && baseballCounterResult.getStrike() == 1) {
            System.out.println(baseballCounterResult.getStrike() + "스트라이크 입니다.");
        } else if (0 == baseballCounterResult.getBall() && baseballCounterResult.getStrike() == 2) {
            System.out.println(baseballCounterResult.getStrike() + "스트라이크 입니다.");
        } else if (baseballCounterResult.getStrike() == 3) {
            System.out.println(baseballCounterResult.getStrike() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.println("낫싱");
        }
    }
}
