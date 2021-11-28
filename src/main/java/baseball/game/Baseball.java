package baseball.game;

public class Baseball {

    private String checkNumber(int[] computerNumbers, int userInput, int index) {

        for (int i = 0; i < 3; i++) {
            if(computerNumbers[i] == userInput && i == index) {
                return "스트라이크";
            } else if (computerNumbers[i] == userInput) {
                return "볼";
            }
        }

        return "낫싱";
    }
}
