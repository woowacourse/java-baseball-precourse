package baseball;

import java.util.Scanner;

public class Game {

    public static final String MSG_SHOULD_TYPE_3_DIFFERENT_DIGITS = "서로 다른 3자리 숫자를 입력해주세요 : ";
    public static final String MSG_GAME_EXIT = "게임종료";
    public static final String MSG_INPUT_ERROR = "입력 오류";

    public boolean startGame(Scanner scanner) {
        String answer = RandomAnswer.randomAnswer();
        String guessNumber;

        System.out.print(MSG_SHOULD_TYPE_3_DIFFERENT_DIGITS);
        while (scanner.hasNext()) {
            guessNumber = scanner.nextLine();
            if (!Validate.isValidate(guessNumber)){
                System.out.println(MSG_INPUT_ERROR);
                System.out.print(MSG_SHOULD_TYPE_3_DIFFERENT_DIGITS);
                continue;
            }
            //TODO: to delete debugging MSG before pull request
            System.out.println("입력값" + guessNumber);
            if (Validate.isAnswer(guessNumber, answer)) {
                if (Replay.doReplay(scanner)) {
                    System.out.print(MSG_SHOULD_TYPE_3_DIFFERENT_DIGITS);
                    answer = RandomAnswer.randomAnswer();
                    continue;
                }
                System.out.println(MSG_GAME_EXIT);
                return false;
            };
            System.out.print(MSG_SHOULD_TYPE_3_DIFFERENT_DIGITS);
        }
        return true;
    }

}
