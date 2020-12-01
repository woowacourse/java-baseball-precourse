package baseball;

import java.util.Scanner;

public class GamePlayer {
    public static final int NUMBER_LENGTH = 3;
    public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static void playGame(Scanner scanner) {
        String answer = AnswerGenerator.generateNumbers(NUMBER_LENGTH);
        String userTrial = UserInput.getNumber(scanner);
        while (true) {
            if (AnswerCheck.compareTrial(answer, userTrial)) {
                break;
            } else {
                userTrial = UserInput.getNumber(scanner);
            }
        }
        System.out.println(CORRECT_MESSAGE);
        GameRestarter.replayGame(scanner);
    }
}
