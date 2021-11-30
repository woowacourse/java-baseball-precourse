package baseball.view;

import baseball.domain.Messages;

public class GameDisplay {
    private static final String NEW_LINE = "\n";

    public static void printRestartOrNotMessage() {
        System.out.println(Messages.RESTART_OR_NOT_MESSAGE.printMessages());
    }

    public static void printCorrectAnswerMessage() {
        System.out.println(Messages.THREE_STRIKE_MESSAGE.printMessages() + NEW_LINE + Messages.COLLECT_ANSWER_MESSAGE.printMessages());
    }

    public static void printInputMessage() {
        System.out.print(Messages.INPUT_NUMBER_MESSAGE.printMessages());
    }

    public static void printHintMessage(final String hintMessage) {
        System.out.println(hintMessage);
    }

}
