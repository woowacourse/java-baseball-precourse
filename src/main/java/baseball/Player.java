package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static int[] getPlayerInput() {
        System.out.print(SystemMessage.REQUEST_INPUT_MESSAGE);
        String input = Console.readLine();
        if (!Validator.isValidateGuess(input)) throw new IllegalArgumentException(SystemMessage.WRONG_INPUT_MESSAGE);

        return parseStringToIntegerArray(input);
    }

    public static String guessNumber(int[] generateNumbers, int[] guessNumbers) {
        int strikeNum = StrikeBallCounter.getStrikeCount(generateNumbers, guessNumbers);
        int ballNum = StrikeBallCounter.getBallCount(generateNumbers, guessNumbers);
        return new GameStatus(strikeNum, ballNum).toString();
    }

    private static int[] parseStringToIntegerArray(String input) {
        int[] guessNumber = new int[Constant.DIGIT_NUM];
        for (int i = 0; i < Constant.DIGIT_NUM; i++) {
            guessNumber[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        return guessNumber;
    }
}
