package baseball.view;

import baseball.util.AnswerRange;
import baseball.util.InputValidator;
import baseball.util.MessageType;

import camp.nextstep.edu.missionutils.Console;

public class GameInputView {
    private final InputValidator inputValidator;

    public GameInputView() {
        inputValidator = new InputValidator();
    }

    public int[] inputAnswer() {
        System.out.print(MessageType.INPUT_NUMBER.getMessage());
        String input = Console.readLine();

        inputValidator.validateInputAnswer(input);

        int[] answer = new int[AnswerRange.DIGIT];

        for (int i = 0; i < AnswerRange.DIGIT; i++) {
            answer[i] = input.charAt(i) - '0';
        }

        return answer;
    }

    public int inputAskReplay() {
        System.out.println(MessageType.INPUT_ASK_REPLAY.getMessage());
        String input = Console.readLine();

        inputValidator.validateInputReplay(input);

        return Integer.parseInt(input);
    }
}
