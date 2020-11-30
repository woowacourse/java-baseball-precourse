package baseball;

public class BaseballPrint {

    public static boolean resultPrint(BaseballCounter baseballCounter) {
        boolean isNotThreeStrike = true;

        if (baseballCounter.isNothing()) {
            System.out.print("낫싱");
        }
        if (baseballCounter.ballCounter()) {
            System.out.printf("%s볼", baseballCounter.getBallCounter());
        }
        if (baseballCounter.strikeCounter()) {
            System.out.printf("%s스트라이크", baseballCounter.getStrikeCounter());
        }
        if (baseballCounter.threeStrikeCounter()) {
            System.out.printf("%s스트라이크", baseballCounter.getStrikeCounter());
            isNotThreeStrike = false;
        }
        System.out.println();

        return isNotThreeStrike;
    }
}
