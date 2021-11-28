package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class GameSystem {

    private static final int SIG_GAME_CONTINUE = 1;
    private static final int SIG_GAME_END = 2;
    private static final String THREE_DIGIT_PATTERN = "^[0-9]{3}+$";

    private int signal;

    GameSystem() {
        signal = SIG_GAME_CONTINUE;
    }

    public void executeGameSystem() {
        while (signal == SIG_GAME_CONTINUE) {
            playGame();
            determineContinueGame();
        }
    }

    private void printResult(final int strikes, final int balls) {
        if (balls != 0) {
            System.out.println(balls + "볼 ");
        }
        if (strikes != 0) {
            System.out.println(strikes + "스트라이크");
        }
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
        }
    }

    private void playGame() {
        OpponentPlayer opponentPlayer = new OpponentPlayer();
        Judge judge = new Judge();
        String user3DigitNum;
        judge.setRightAnswer(opponentPlayer.pickRandom3DigitNum());
        while (true) {
            user3DigitNum = getUser3DigitNum();
            judge.initialize();
            judge.makeJudgement(user3DigitNum);
            printResult(judge.getStrike(), judge.getBall());
            if (judge.getGameSuccess()) {
                break;
            }
        }
    }

    private String getUser3DigitNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input3DigitNum = Console.readLine();
        if (!Pattern.matches(THREE_DIGIT_PATTERN, input3DigitNum)) {
            throw new IllegalArgumentException();
        }
        return input3DigitNum;
    }

    private void determineContinueGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. : ");
        String users_signal = Console.readLine();
        if (users_signal.equals("1")) {
            return;
        }
        if (users_signal.equals("2")) {
            signal = SIG_GAME_END;
            return;
        }
        throw new IllegalArgumentException();
    }
}