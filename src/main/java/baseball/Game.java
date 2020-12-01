package baseball;

import java.util.Scanner;

public class Game {

    public static final String MSG_TYPE_DIGITS = "숫자를 입력해주세요 : ";
    public static final String MSG_GAME_EXIT = "게임종료";
 static final int MODE_VALIDATE = 1;

    public boolean startGame(Scanner scanner) {
        String answer = RandomAnswer.randomAnswer();
        String guessNumber;

        System.out.print(MSG_TYPE_DIGITS);
        while (scanner.hasNext()) {
            guessNumber = scanner.nextLine();
            if (!Validate.isValidate(guessNumber, MODE_VALIDATE)){
                System.out.print(MSG_TYPE_DIGITS);
                continue;
            }
            if (Validate.isAnswer(guessNumber, answer)) {
                if (Replay.doReplay(scanner)) {
                    System.out.print(MSG_TYPE_DIGITS);
                    answer = RandomAnswer.randomAnswer();
                    continue;
                }
                System.out.println(MSG_GAME_EXIT);
                return false;
            }
            System.out.print(MSG_TYPE_DIGITS);
        }
        return true;
    }

}
