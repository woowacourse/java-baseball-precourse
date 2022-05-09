package baseball;

import controller.BaseballController;
import domain.Computer;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        BaseballController baseballController = new BaseballController();
        baseballController.run();
    }
}
