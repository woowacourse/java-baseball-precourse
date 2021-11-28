package baseball.game;

public class Baseball {

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
