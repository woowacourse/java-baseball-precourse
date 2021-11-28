package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static final int START_GAME_VALUE = 1;
    private static final int END_GAME_VALUE = 2;

    public static void main(String[] args) {
        int gameStatus = START_GAME_VALUE;

        while (gameStatus != END_GAME_VALUE) {

        }
    }
}

class Game {
    List<Integer> answer;

    public Game() {
    }

    public void startGame() {
        initAnswer();
    }

    private void initAnswer() {
        for (int i = 0; i < 3; i++) {
            answer.add(getUniqueNumber());
        }
    }

    private int getUniqueNumber() {
        int number;

        while(true) {
            number = Randoms.pickNumberInRange(0, 9);

            if (!answer.contains(number)) return number;
        }
    }
}
