package baseball;

public class BaseballGame {

    private BaseballGameInput baseballGameInput;
    private final int RESTART = 1;

    public BaseballGame(BaseballGameInput baseballGameInput) {
        this.baseballGameInput = baseballGameInput;
    }

    public void run() {

        BaseballNumbers computerBaseballNumbers;
        BaseballNumbers userBaseballNumbers;

        BaseballGameResult baseballGameResult;

        computerBaseballNumbers = RandomBaseballNumbersGenerator.generate();

        do {
            String baseballNumbersInput = baseballGameInput.baseballNumbersInput();
            userBaseballNumbers = BaseballNumbers
                    .getBaseballNumberFromString(baseballNumbersInput);

            if (!BaseballNumbersValidator.isValid(userBaseballNumbers)
                    || !BaseballNumbersValidator.isValid(computerBaseballNumbers)) {
                throw new IllegalArgumentException();
            }

            baseballGameResult = BaseballGameResult
                    .getBaseballGameResult(computerBaseballNumbers, userBaseballNumbers);
            System.out.println(baseballGameResult.toString());
        } while(baseballGameResult.isFinished());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        String restartOrExitInput = baseballGameInput.restartOrExitInput();
        if(!RestartOrExitValidator.isValid(restartOrExitInput)) throw new IllegalArgumentException();

        if(Integer.parseInt(restartOrExitInput) == RESTART) run();
    }
}
