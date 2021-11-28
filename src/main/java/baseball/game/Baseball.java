package baseball.game;

import static baseball.util.RandomUtil.createComputerNumbers;
import static baseball.util.UserInputUtil.checkProgress;
import static baseball.util.UserInputUtil.getThreeDigitInput;

public class Baseball {

    public void startGame() {

        while(true) {
            progressGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            boolean check = checkProgress();

            if (check == false) {
                break;
            }
        }
    }

    private void progressGame() {

        int[] computerNumbers = createComputerNumbers();

        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");

            int[] userInput = getThreeDigitInput();

            for (int i = 0; i < 3; i++) {
                String result = checkNumber(computerNumbers, userInput[i], i);

                if (result.equals("스트라이크")) {
                    strike++;
                } else if (result.equals("볼")) {
                    ball++;
                }
            }

            System.out.println(makeMessage(strike, ball));

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }

    private String checkNumber(int[] computerNumbers, int userInput, int index) {

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userInput && i == index) {
                return "스트라이크";
            } else if (computerNumbers[i] == userInput) {
                return "볼";
            }
        }

        return "낫싱";
    }

    private String makeMessage(int strike, int ball) {

        String message = "";

        if (strike == 0 && ball == 0) {
            message = "낫싱";
        }

        if (ball > 0) {
            message = ball + "볼 ";
        }

        if (strike > 0) {
            message = strike + "스트라이크";
        }

        return message;
    }
}
