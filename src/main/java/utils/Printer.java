package utils;

public class Printer {
    public void printInputGuide() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int ballNumber, int strikeNumber) {
        if (ballNumber == 0 && strikeNumber == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder outputBuilder = new StringBuilder();

        if (ballNumber > 0) {
            outputBuilder.append(ballNumber).append("볼");
        }

        if (strikeNumber > 0) {
            if (ballNumber > 0) {
                outputBuilder.append(" ");
            }

            outputBuilder.append(strikeNumber).append("스트라이크");
        }

        System.out.println(outputBuilder.toString());
    }

    public void printGameProgess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
