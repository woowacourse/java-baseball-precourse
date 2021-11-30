package baseball.util;

public enum MessageType {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    INPUT_ASK_REPLAY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),

    OUTPUT_RESULT_BALL("볼"),
    OUTPUT_RESULT_STRIKE("스트라이크"),
    OUTPUT_RESULT_NOTHING("낫싱"),
    OUTPUT_CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

    ERROR_NOT_THREE_DIGIT("[입력 에러] 3개의 숫자만 입력해야 합니다. 게임 종료"),
    ERROR_OUT_OF_RANGE("[입력 에러] 1부터 9까지의 숫자만 입력해야 합니다. 게임 종료"),
    ERROR_NOT_NUMBER("[입력 에러] 숫자만 입력해야 합니다. 게임 종료"),
    ERROR_NOT_DUPLICATE("[입력 에러] 각 자리의 숫자는 중복될 수 없습니다. 게임 종료"),
    ERROR_NOT_ONE_DIGIT("[입력 에러] 1개의 숫자만 입력해야 합니다. 게임 종료"),
    ERROR_ONE_OR_TWO("[입력 에러] 1 혹은 2 중에서의 숫자만 입력해야 합니다. 게임 종료");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
