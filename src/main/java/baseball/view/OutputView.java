package baseball.view;

import baseball.constant.SystemMessage;

public class OutputView {
    public static void printHintMessage(int[] computerHint) {
        if (computerHint[0] != 0) {
            System.out.print(computerHint[0] + SystemMessage.BALL_MESSAGE + " ");
        }

        if (computerHint[1] != 0) {
            System.out.print(computerHint[1] + SystemMessage.STRIKE_MESSAGE + " ");
        }

        if (computerHint[0] == 0 && computerHint[1] == 0) {
            System.out.print(SystemMessage.NOTHING_MESSAGE + " ");
        }
        System.out.println();
    }

    public static void printGameSetMessage(){
        System.out.println(SystemMessage.GAME_SET_MESSAGE);
    }
}
