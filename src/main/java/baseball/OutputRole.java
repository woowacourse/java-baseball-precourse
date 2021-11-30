package baseball;

import camp.nextstep.edu.missionutils.Console;

public class OutputRole {

    private static final String NOTHING = "낫싱 ";
    private static final String STRIKE = "스트라이크 ";
    private static final String BALL = "볼 ";
    private static final String SUCCESS_MISSIOLN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 ";
    private static final String RESTART_INSTRUCTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";


    public void printResult(int strikeNumber, int ballNumber) {
        if (checkNothing(strikeNumber, ballNumber)) {
            System.out.print(NOTHING);
        }
        if (ballNumber > 0) {
            System.out.print(ballNumber + BALL);
        }
        if (strikeNumber > 0) {
            System.out.print(strikeNumber + STRIKE);
        }
        System.out.println();

    }

    public boolean isStrike(int strikeNumber) {
        if (strikeNumber == 3) {
            System.out.println(SUCCESS_MISSIOLN);
            return true;
        }

        return false;
    }

    private boolean checkNothing(int strike, int ball) {
        return strike <= 0 && ball <= 0;
    }


    public boolean restartResult() {
        System.out.println(RESTART_INSTRUCTION);
        String input = Console.readLine();
        if (input.equals(RESTART_COMMAND)) {
            return true;
        }
        if (input.equals(EXIT_COMMAND)) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 값을 입력했습니다. 1 또는 2를 입력해주세요.");

    }
}
