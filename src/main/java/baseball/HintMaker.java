package baseball;

import constant.MessageList;

public class HintMaker {
    private int strikeCount;
    private int ballCount;

    public HintMaker(int strikeCount, int ballCount) {
        clear();
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAnswer() {
        if (strikeCount == MessageList.SIZE_RANGE) {
            System.out.println(MessageList.ANSWER_MESSAGE);
            return true;
        }
        return false;
    }

    public void makePrintMessage() {
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

    public void clear() {
        strikeCount = 0;
        ballCount = 0;
    }
}
