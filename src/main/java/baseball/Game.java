package baseball;

import java.util.List;

public class Game {

    Computer computer;
    Player player;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void playGame() {

        boolean strikeOut;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String[] inputFromUser = player.guessDeck();

            Validator validator = new Validator();
            List<Integer> playerExpectDeck = validator.validatePlayerInput(inputFromUser);

            Referee referee = new Referee(computer.getDeck());
            referee.judgePlayerDeck(playerExpectDeck);

            strikeOut = referee.checkStrikeOut();
        } while (!strikeOut);
    }
}
