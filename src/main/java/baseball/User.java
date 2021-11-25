package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class User {

    private static final int RANDOM_START_INCLUSIVE = 1;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";

    public boolean checkAnswer(final String answer, final String guessNumber) {
        return answer.equals(guessNumber);
    }

    public void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public String inputPlayerNumber() {
        return Console.readLine();
    }

    public String connectEachAnswerNumbers() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            stringBuilder.append(inputAnswerNumber());
        }

        return stringBuilder.toString();
    }

    private int inputAnswerNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

}
