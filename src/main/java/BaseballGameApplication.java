public class BaseballGameApplication {
    public static void main(String[] args) {
        int nextStep;

        do {
            startNewGame();
            OutputBaseballGame.printFinishMsg();
            nextStep = InputBaseballGame.inputNextStep();
        } while (nextStep == 1);
    }

    public static void startNewGame() {
        int userNumber;
        int strikeCount, ballCount;
        BaseballGameSystem game = new BaseballGameSystem();

        do {
            userNumber = InputBaseballGame.inputUserNumber();

            game.checkAnswer(userNumber);

            strikeCount = game.getStrikeCount();
            ballCount = game.getBallCount();
            OutputBaseballGame.printPitchResult(strikeCount, ballCount);

            game.setStrikeCount(0);
            game.setBallCount(0);
        } while (strikeCount != 3);
    }
}
