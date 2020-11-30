package views;

public class Output {
    public static void printSelect() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printHint(int strikeNumber, int ballNumber) {
        if (strikeNumber == 0 && ballNumber == 0) {
            System.out.println("낫싱");
        } else if (strikeNumber == 0) {
            System.out.printf("%d볼\n", ballNumber);
        } else if (ballNumber == 0) {
            System.out.printf("%d스트라이크\n", strikeNumber);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballNumber, strikeNumber);
        }
    }

    public static void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
