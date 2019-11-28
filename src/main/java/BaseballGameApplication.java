public class BaseballGameApplication {
    public static void main(String[] args) {
        int nextStep;

        startNewGame();
        OutputBaseballGame.printFinishMsg();
        nextStep = InputBaseballGame.inputNextStep();

        switch (nextStep) {
            case 1:
                startNewGame();

            case 2:
                return;
        }
    }

    public static void startNewGame() {
        int userNumber;
        int strikeCount = 0, ballCount;
        BaseballGameSystem game = new BaseballGameSystem();

        while (strikeCount != 3) {
            userNumber = InputBaseballGame.inputUserNumber();

            game.checkAnswer(userNumber);
            strikeCount = game.getStrikeCount();
            ballCount = game.getBallCount();
            OutputBaseballGame.printPitchResult(strikeCount, ballCount);

            game.setStrikeCount(0);
            game.setBallCount(0);
        }
    }
}
