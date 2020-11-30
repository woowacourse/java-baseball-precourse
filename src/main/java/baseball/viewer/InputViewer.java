package baseball.viewer;

public class InputViewer {
    /* 숫자를 입력 받을 때, 사용자에게 보여주는 메세지를 표현하는 메서드 */
    public static void receiveNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    /* 정수 조합 입력시에 3자리 숫자를 초과 오류를 사용자에게 보여주는 메서드 */
    public static void excessDigits() {
        throw new IllegalArgumentException("3자리 초과하였습니다.");
    }

    /* 정수 조합 입력시에 3자리 숫자를 미달 오류를 사용자에게 보여주는 메서드 */
    public static void lackDigits() {
        throw new IllegalArgumentException("3자리 미만입니다.");
    }

    /* 숫자 이외의 형식들을 입력 오류를 보여주는 메서드 */
    public static void violentIntegerRule() {
        throw new IllegalArgumentException("입력값은 정수여야만 합니다.");
    }

    /* 0을 입력했을 때 입력 오류를 보여주는 메서드 */
    public static void zeroCheck() {
        throw new IllegalArgumentException("0이외의 각자리가 1~9로 구성된 숫자를 입력해주세요.");
    }

    /* 중복된 자리 수를 입력했을 때 오류를 보여주는 메서드 */
    public static void overlappedReceive() {
        throw new IllegalArgumentException("중복된 자리 수들을 입력하셨습니다.");
    }

    /* 유효하지 못한 재시작 옵션을 입력했을 때 보여주는 메서드 */
    public static void noValidRestart() {
        throw new IllegalArgumentException("유효하지 못한 재시작 입력입니다.");
    }
}
