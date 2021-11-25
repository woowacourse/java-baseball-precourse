package baseball;

import baseball.domain.BaseballReferee;
import baseball.domain.GameMachine;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine(new BaseballReferee(), new InputView());
        gameMachine.run();
    }
}