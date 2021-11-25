package baseball;

public class Printer {

    public void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResultBall(int ball) {
        System.out.print(ball + "볼 ");
    }

    public void printResultStrike(int strike) {
        System.out.print(strike + "스트라이크");
    }

    public void printResultNoting() {
        System.out.println("낫싱");
    }

    public void printResultGameEnd() {
        System.out.println("3스트라이크" +
                System.lineSeparator() +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
