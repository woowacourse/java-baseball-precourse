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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isContinue = BaseballValidateInput.isContinueNumberValidate(scanner.nextLine());
        }
    }

    public void game() {
        BaseballNumber baseballRandomNumber = new BaseballNumber();
        boolean isNotThreeStrike = true;
        while (isNotThreeStrike) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = scanner.nextLine();
            BaseballValidateInput.playerNumberValidate(playerInput);
            BaseballNumber baseballplayerNumber = new BaseballNumber(playerInput);
            BaseballCounter baseballCounter = BaseballCompare.compare(baseballRandomNumber, baseballplayerNumber);
            isNotThreeStrike = BaseballPrint.resultPrint(baseballCounter);
        }
    }
}
