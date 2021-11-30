package baseball;

public class Printer {

    public void printNumberInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResultBall(int ball) {
        System.out.print(ball + "볼 ");
    }

    public void printResultStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public void printResultNoting() {
        System.out.println("낫싱");
    }

    public void printResultGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
