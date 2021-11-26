package baseball;

public class Application {
    private static final String FAILED = "failed";
    private static final String RESTART = "1";
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String status = FAILED;
        Balls computerBalls = new Balls();

        while (status.equals(FAILED) || status.equals(RESTART)) {
            Balls userBalls = new Balls(inputView.attempt());
            GameResult result = new GameResult(computerBalls, userBalls);

            outputView.printResult(result);
            status = setStatus(result);
            computerBalls = setComputerBalls(status, computerBalls);
        }
    }

    private static String setStatus(GameResult result) {
        if (result.isEnd()) {
            return inputView.askRestart();
        }
        return FAILED;
    }

    private static Balls setComputerBalls(String status, Balls computerBalls) {
        if (status.equals(RESTART)) {
            return new Balls();
        }
        return computerBalls;
    }
}
