public class BaseballGameApplication {
    public static void main(String[] args) {
        int userNumber;
        int strikeCount, ballCount;
        BaseballGameSystem game = new BaseballGameSystem();

        userNumber = InputBaseballGame.inputUserNumber();
        game.checkAnswer(userNumber);
        strikeCount = game.getStrikeCount();
        ballCount = game.getBallCount();
        OutputBaseballGame.printPitchResult(strikeCount, ballCount);
    }
}
