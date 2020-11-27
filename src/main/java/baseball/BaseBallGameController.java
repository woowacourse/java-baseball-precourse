package baseball;

import utils.RandomUtils;
import static baseball.Config.*;

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

}
