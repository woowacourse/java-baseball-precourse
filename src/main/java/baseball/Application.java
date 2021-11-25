package baseball;

import baseball.domain.GameMachine;

public class Application {
    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        gameMachine.run();
    }
}