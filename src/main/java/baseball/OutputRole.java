package baseball;

import camp.nextstep.edu.missionutils.Console;

public class OutputRole {

    private static final String NOTHING = "낫싱 ";
    private static final String STRIKE = "스트라이크 ";
    private static final String BALL = "볼 ";
    private static final String SUCCESS_MISSIOLN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 ";
    private static final String RESTART_INSTRUCTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


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
            allowRestart();
        }
        return false;


    }

    private boolean checkNothing(int strike, int ball) {
        return strike <= 0 && ball <= 0;
    }


    private boolean allowRestart(){
        System.out.println(RESTART_INSTRUCTION);
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 값을 입력했습니다. 1 또는 2를 입력해주세요.");

    }
}
