package baseball;

import utils.RandomUtils;
import utils.InputCheckUtils;

import static baseball.Config.*;
import static utils.TextResource.STATEMENT_NOT_VALID_INPUT;

public class BaseBallGameController {
    private Player player = null;
    private BaseBallGame game = null;

    public BaseBallGameController(Player player) {
        this.player = player;
    }

    private String makeRandomNumber() {
        StringBuilder randomNumber = new StringBuilder();
        while (true) {
            String num = Integer.toString(RandomUtils.nextInt(START_INCLUSIVE_NUM, END_INCLUSIVE_NUM));
            if (randomNumber.toString().contains(num)) {
                continue;
            }
            randomNumber.append(num);
            if (randomNumber.length() == NUMBER_OF_DIGITS) {
                return randomNumber.toString();
            }
        }
    }

    private boolean checkValidInput(String inputNumber) {
        try {
            if (!InputCheckUtils.isNumeric(inputNumber)) {
                throw new IllegalArgumentException();
            }

            if (inputNumber.length() > NUMBER_OF_DIGITS || inputNumber.length() < NUMBER_OF_DIGITS) {
                throw new IllegalArgumentException();
            }

            if (InputCheckUtils.hasDuplicated(inputNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(STATEMENT_NOT_VALID_INPUT);
            return false;
        }
        return true;
    }
}
