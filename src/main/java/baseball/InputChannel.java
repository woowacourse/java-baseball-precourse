package baseball;

import java.util.Scanner;

public class InputChannel {
    private static final String QUESTION_FOR_BASEBALL_NUMBER = "숫자를 입력해주세요 : ";
    private static final String CONGRATULATION_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String QUESTION_FOR_RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int RE_GAME_CODE = 1;

    private InputChannel() {
    }

    public static int askBaseballNumber(Scanner scanner) {
        System.out.print(QUESTION_FOR_BASEBALL_NUMBER);
        try {
            int inputInt = convertStringToInt(scanner.nextLine().strip());
            Validator.ValidateBaseBallNumber(inputInt);
            return inputInt;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askBaseballNumber(scanner);
        }
    }

    public static boolean askReGame(Scanner scanner) {
        System.out.println(CONGRATULATION_MESSAGE);
        System.out.println(QUESTION_FOR_RE_GAME);
        try {
            int inputInt = convertStringToInt(scanner.nextLine().strip());
            Validator.ValidateReGameCode(inputInt);
            return inputInt == RE_GAME_CODE;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return askReGame(scanner);
        }
    }

    private static int convertStringToInt(String string) {
        Validator.ValidateStringToInt(string);
        return Integer.parseInt(string);
    }
}
