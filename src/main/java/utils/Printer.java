package utils;

public class Printer {
    public void printInputGuide() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printResult(int[] ballsAndStrikes) {
        int balls = ballsAndStrikes[0];
        int strikes = ballsAndStrikes[1];

        if (balls == 0 && strikes == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder outputBuilder = new StringBuilder();

        if (balls > 0) {
            outputBuilder.append(balls).append("볼");
        }

        if (strikes > 0) {
            if (balls > 0) {
                outputBuilder.append(" ");
            }

            outputBuilder.append(strikes).append("스트라이크");
        }

        System.out.println(outputBuilder.toString());
    }

    public void printGameProgess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
