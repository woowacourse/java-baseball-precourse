package baseball;

import constants.NumberAttribute;
import camp.nextstep.edu.missionutils.Console;

import constants.HintMessage;
import utils.NumberGenerator;

public class Game {
    private static String CLEAR_CONDITION_MESSAGE;
    Umpire umpire;

    Game() {
         CLEAR_CONDITION_MESSAGE = NumberAttribute.DIGIT_NUMBER.getValue() + HintMessage.STRIKE.message();
         String randomNumber = NumberGenerator.generateRandomNumber();
         umpire = new Umpire(randomNumber);

    }

    public void playGame() {
        boolean isGameContinue = true;
        do {
            String userNumber = Console.readLine();
            inputValidation(userNumber);

            String result = umpire.judgeRound(userNumber);
            isGameContinue = !result.equals(CLEAR_CONDITION_MESSAGE);

        } while (isGameContinue);
    }

    public void inputValidation (final String userInput){
        boolean isInvalid = !InputValidator.checkUserInput(userInput);
        if(isInvalid){
            throw new IllegalArgumentException("사용자 입력이 잘못된 값이므로 게임을 종료합니다");
        }
    }

}
