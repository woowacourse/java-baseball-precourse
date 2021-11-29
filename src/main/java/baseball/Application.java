package baseball;

import baseball.game.User;
import baseball.utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        System.out.println(RandomUtils.RandomNumberList());
        System.out.println(User.inputNumber());
    }
}
