package baseball;

import static utils.InputValidator.checkExitCommandIsValid;

import constants.ExitOption;
import constants.NumberAttribute;
import constants.HintMessage;
import constants.SystemMessage;
import utils.InputValidator;
import utils.NumberGenerator;

import camp.nextstep.edu.missionutils.Console;


public class Game {

    private static String CLEAR_CONDITION_MESSAGE;
    Umpire umpire;

    Game() {

        CLEAR_CONDITION_MESSAGE = NumberAttribute.DIGIT_NUMBER.getValue() + HintMessage.STRIKE.getHint();
    }

    public void init() {

        umpire = new Umpire(NumberGenerator.generateRandomNumber());
    }

    public void playGame() {

        boolean isGameContinue = true;
        do {
            System.out.println(SystemMessage.INPUT_REQUEST.getMessage());
            String userNumber = Console.readLine();
            if (!InputValidator.checkUserInputIsValid(userNumber)) {
                throw new IllegalArgumentException("사용자 입력이 잘못된 값이므로 게임을 종료합니다");
            }

            String result = umpire.judgeRound(userNumber);
            System.out.println(result);
            isGameContinue = !result.equals(CLEAR_CONDITION_MESSAGE);

        } while (isGameContinue);
        System.out.println(SystemMessage.GAME_CLEAR.getMessage());
    }

    public boolean checkUserWantRestart() {

        System.out.println(SystemMessage.RESTART_OR_END_REQUEST.getMessage());
        String userInput = Console.readLine();
        if (!checkExitCommandIsValid(userInput)) {
            throw new IllegalArgumentException("게임 종료 옵션 커맨드가 잘못된 값이므로 게임을 종료합니다");
        }

        return userInput.equals(ExitOption.RESTART.getCommand());
    }
}

