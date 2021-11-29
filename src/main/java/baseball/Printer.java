package baseball;

public class Printer {

    public void printData(Data data) {
        if (data.isCorrect()) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if (data.isNothing()) {
            System.out.println("낫싱");
        }
        else {
            System.out.printf("%d볼 %d스트라이크\n", data.getBall(), data.getStrike());
        }
    }

}
