package baseball;

public class BaseBallResult {
    int ballCount = 0;
    int strikeCount = 0;

    @Override
    public String toString() {
        String result = "";
        if (ballCount > 0) {
            result += ballCount + "볼";
        }
        if (strikeCount > 0) {
            result += " " + strikeCount + "스트라이크";
        }
        if (ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
        }
        return result.trim();
    }
}
