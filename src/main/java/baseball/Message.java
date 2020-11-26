package baseball;

public class Message {
    public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String CONTINUE_ASK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_ASK_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_CONTINUE_INPUT_ERROR_MESSAGE = "1 또는 2로만 입력해야 합니다.";
    public static final String INPUT_MISMATCH_WARN_MESSAGE = "숫자를 입력해야 합니다.";
    public static final String DUPLICATE_WARNING_MESSAGE = "각기 다른 수를 입력하셔야 합니다.";
    public static final String LENGTH_WARNING_MESSAGE = "3자리 수를 입력하셔야 합니다.";
    public static final String NOTHING_MESSAGE = "낫싱";

    public static void ballMessage(int ball) {
        System.out.println(ball + "볼");
    }

    public static void strikeMessage(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public static void ballAndStrikeMessage(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
