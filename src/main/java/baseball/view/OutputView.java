package baseball.view;

public class OutputView {
    public static void printResult(int balls, int strikes) {
        if (balls == 0 && strikes == 0) System.out.println("낫싱");
        else if (strikes == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        else System.out.println(balls + "볼 " + strikes + "스트라이크");
    }

    public static void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
