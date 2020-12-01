package baseball;

public class BaseballGame {

    private BaseballGameInput baseballGameInput;
    private BaseballNumbers computerBaseballNumbers;
    private BaseballNumbers userBaseballNumbers;
    private BaseballGameResult baseballGameResult;

    private final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final int RESTART = 1;

    public BaseballGame(BaseballGameInput baseballGameInput) {
        this.baseballGameInput = baseballGameInput;
    }

    public void run() {
        if(gameLogicAndIsRestart()) {
            run();
        }
    }

    private boolean gameLogicAndIsRestart() {
        computerBaseballNumbers = RandomBaseballNumbersGenerator.generate();

        do {
            userBaseballNumbers = BaseballNumbers
                    .getBaseballNumberFromString(baseballGameInput.baseballNumbersInput());

            baseballGameResult = BaseballGameResult
                    .getBaseballGameResult(computerBaseballNumbers, userBaseballNumbers);

            System.out.println(baseballGameResult.toString());
        } while(baseballGameResult.isFinished());

        return isRestart();
    }

    private boolean isRestart() {
        System.out.println(FINISH_MESSAGE);
        String restartOrExitInput = baseballGameInput.restartOrExitInput();
        return Integer.parseInt(restartOrExitInput) == RESTART;
    }
}
