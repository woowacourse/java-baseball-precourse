package baseball.viewer;

public class InputViewer {
    public static void receiveNumber() {
        System.out.print("숫자를 입력해주세요 :");
    }

    public static void excessDigits() {
        System.out.println("3자리 초과하였습니다.");
    }

    public static void lackDigits() {
        System.out.println("3자리 미만입니다.");
    }

    public static void violentIntegerRule() {
        System.out.println("입력값은 정수여야만 합니다.");
    }

    public static void zeroCheck() {
        System.out.println("0이외의 1~9자리로 구성된 숫자를 입력해주세요");
    }

    public static void overlappedReceive() {
        System.out.println("유효하지 못한 입력입니다.");
    }
}
