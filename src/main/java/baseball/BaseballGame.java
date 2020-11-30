package baseball;

import java.util.*;

public class BaseballGame {
    private final Scanner scanner;

    public BaseballGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        boolean isContinue = true;
        while (isContinue) {
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.");
            isContinue = BaseballValidateInput.isContinueNumberValidate(scanner.nextLine());
        }
    }

    public void game() {
        BaseballNumber randomBaseballNumber = new BaseballNumber();
        boolean answer = true;
        while (answer) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = scanner.nextLine();
            BaseballValidateInput.playerNumberValidate(playerInput);
            BaseballNumber playerBaseballNumber = new BaseballNumber(playerInput);
            BaseballCounterResult baseballCounterResult = BaseballNumberCompare.compare(randomBaseballNumber.getNumbers(), playerBaseballNumber.getNumbers());
            BaseballResultPrint.resultPrint(baseballCounterResult);

            answer = baseballCounterResult.getStrike() != 3;
        }
    }
}
