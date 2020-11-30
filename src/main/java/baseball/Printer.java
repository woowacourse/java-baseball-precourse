package baseball;

public class Printer {
    public static void result(BaseballResult baseballResult) {
        System.out.println(baseballResult.getResult());
    }

    public static void isCorrect() {
        String message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        System.out.println(message);
    }

    public static void askRestart() {
        String message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(message);
    }

    public static void inputNumber() {
        String message = "숫자를 입력해주세요 : ";
        System.out.print(message);
    }

    public static void onlyNumber() {
        String message = "숫자 형식을 입력해주세요.";
        System.out.println(message);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
