package baseball;

public class BaseballValidateInput {
    private static final int RETRY_NUMBER = 1;
    private static final int END_NUMBER = 2;
    private static final int COLLECT_PLAYER_NUMBER_LENGTH = 3;

    public static void playerNumberValidate(String playerInput) {
        if (playerInput.length() != COLLECT_PLAYER_NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static boolean isContinueNumberValidate(String isContinueNum) {
        if (Integer.parseInt(isContinueNum) == RETRY_NUMBER) {
            return true;
        } else if (Integer.parseInt(isContinueNum) == END_NUMBER) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
