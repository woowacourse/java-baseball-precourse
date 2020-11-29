package baseball.viewer;

public class InputViewer {
    public static void receiveNumber() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public static void excessDigits() {
        throw new IllegalArgumentException("3자리 초과하였습니다.");
    }

    public static void lackDigits() {
        throw new IllegalArgumentException("3자리 미만입니다.");
    }

    public static void violentIntegerRule() {
        throw new IllegalArgumentException("입력값은 정수여야만 합니다.");
    }

    public static void zeroCheck() {
        throw new IllegalArgumentException("0이외의 각자리가 1~9로 구성된 숫자를 입력해주세요.");
    }

    public static void overlappedReceive() {
        throw new IllegalArgumentException("중복된 자리 수들을 입력하셨습니다.");
    }

    public static void noValidRestart() {
        throw new IllegalArgumentException("유효하지 못한 재시작 입력입니다.");
    }
}
