package baseball;

public class BaseballGame {

    static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    static final int RESTART = 1;
    static final int EXIT = 2;

    private BaseballGameInput baseballGameInput;
    private BaseballNumbers computerBaseballNumbers;
    private BaseballNumbers userBaseballNumbers;
    private BaseballGameResult baseballGameResult;

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
