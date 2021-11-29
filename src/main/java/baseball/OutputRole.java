package baseball;

import camp.nextstep.edu.missionutils.Console;

public class OutputRole {

    private static final String NOTHING = "낫싱 ";
    private static final String STRIKE = "스트라이크 ";
    private static final String BALL = "볼 ";
    private static final String SUCCESS_MISSIOLN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 ";


    public boolean printResult(int strikeNumber, int ballNumber) {
        if (checkNothing(strikeNumber, ballNumber)) {
            System.out.println(NOTHING);
            return false;
        }
        if (ballNumber > 0) {
            System.out.print(ballNumber + BALL);
        }
        if (strikeNumber > 0) {
            System.out.print(strikeNumber + STRIKE);
        }
        System.out.println();
        if (strikeNumber == 3) {
            System.out.println(SUCCESS_MISSIOLN);
        }
        return false;


    }

    private boolean checkNothing(int strike, int ball) {
        return strike <= 0 && ball <= 0;
    }



}
