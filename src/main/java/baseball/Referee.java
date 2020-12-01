package baseball;

public class Referee {
    static final String STRIKE = "스트라이크";
    static final String BALL = "볼";
    static final String NOTHING = "낫싱";

    public static String judgeNumber(String randomNumber, String inputNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i=0; i < randomNumber.length(); i++) {
            if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
                strikeCount++;
            } else if (randomNumber.contains(Character.toString(inputNumber.charAt(i)))) {
                ballCount++;
            }
        }
        return judgeToString(strikeCount, ballCount);
    }

    public static String judgeToString(int strikeCount, int ballCount) {
        if (strikeCount == Application.NUMBER_LENGTH) {
            return Integer.toString(strikeCount) + STRIKE;
        }
        if (ballCount >0 && strikeCount >0) {
            return Integer.toString(ballCount) + BALL + " " + Integer.toString(strikeCount) + STRIKE;
        } else if (ballCount > 0) {
            return Integer.toString(ballCount) + BALL;
        } else if (strikeCount > 0) {
            return Integer.toString(strikeCount) + STRIKE;
        }
        return NOTHING;
    }
}
