package baseball.domain;

public class Viewer {
    public static void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStrikeBall(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball);
            sb.append("볼");
            sb.append(" ");
        }
        if (strike != 0) {
            sb.append(strike);
            sb.append("스트라이크");
        }
        if (strike == 3) {
            sb.append("\n");
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }

    public static void printEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
