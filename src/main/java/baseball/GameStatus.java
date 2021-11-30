package baseball;

public class GameStatus {
    private final int strikeNum;
    private final int ballNum;

    public GameStatus(int strikeNum, int ballNum) {
        this.strikeNum = strikeNum;
        this.ballNum = ballNum;
    }

    public String toString() {
        String gameResult = "";

        if (strikeNum == Constant.ZERO && ballNum == Constant.ZERO) gameResult += SystemMessage.NOTHING;
        if (ballNum > Constant.ZERO) gameResult += ballNum + SystemMessage.BALL + " ";
        if (strikeNum > Constant.ZERO) gameResult += strikeNum + SystemMessage.STRIKE;

        return removeBlankAtEnd(gameResult);
    }

    private String removeBlankAtEnd(String targetString) {
        if (targetString.charAt(targetString.length() - 1) == Constant.BLANK) {
            return targetString.substring(0, targetString.length() - 1);
        } else return targetString;
    }
}
