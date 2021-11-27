package baseball;

import constant.MessageList;

public class HintMaker {

    private HintMaker() {
    }

    public static boolean isAnswer(int strikeCount) {
        if (strikeCount == MessageList.SIZE_RANGE) {
            System.out.println(MessageList.ANSWER_MESSAGE);
            return true;
        }
        return false;
    }

    public static void makePrintMessage(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount > MessageList.MIN_RANGE_ZERO) {
            sb.append(ballCount + MessageList.BALL_MESSAGE);
        }
        if (strikeCount > MessageList.MIN_RANGE_ZERO) {
            sb.append(strikeCount + MessageList.STRIKE_MESSAGE);
        }
        if ((ballCount == MessageList.MIN_RANGE_ZERO) && (strikeCount == MessageList.MIN_RANGE_ZERO)) {
            sb.append(MessageList.NOTHING_MESSAGE);
        }
        System.out.println(sb);
    }
}
