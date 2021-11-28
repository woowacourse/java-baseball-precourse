package baseball.domain.computer;

import static baseball.domain.number.BaseBallNumbers.BASEBALL_NUMBERS_LIMIT_SIZE;

import baseball.domain.number.BaseBallNumber;
import baseball.domain.number.BaseBallNumbers;
import baseball.exception.computer.ComputerEndStateRefreshException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final BaseBallNumbers answerNumbers;
    private GameState gameState;

    private Computer(BaseBallNumbers answerNumbers, GameState gameState) {
        this.answerNumbers = answerNumbers;
        this.gameState = gameState;
    }

    static Computer from(BaseBallNumbers answerNumbers, GameState gameState) {
        return new Computer(answerNumbers, gameState);
    }

    public static Computer init() {
        return createWithAnswerNumbersByRandomGenerator(GameState.init());
    }

    private static Computer createWithAnswerNumbersByRandomGenerator(GameState gameState) {
        BaseBallNumbers answerNumbers = BaseBallNumbers.createByIntegerNumbers(generateNumbers());
        return new Computer(answerNumbers, gameState);
    }

    private static List<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != BASEBALL_NUMBERS_LIMIT_SIZE) {
            numbers.add(Randoms.pickNumberInRange(BaseBallNumber.MIN_NUMBER, BaseBallNumber.MAX_NUMBER));
        }
        return new ArrayList<>(numbers);
    }

    public GameResult calculateBaseBallGame(BaseBallNumbers baseBallNumbers) {
        int strikeCount = answerNumbers.calculateStrikeCounts(baseBallNumbers);
        int ballCount = answerNumbers.calculateBallCounts(baseBallNumbers);
        return GameResult.from(strikeCount, ballCount);
    }

    public Computer refresh() {
        if (gameState.isEndGame()) {
            throw new ComputerEndStateRefreshException();
        }
        if (gameState.isRestartGame()) {
            return init();
        }
        return this;
    }

    public boolean isFinishedGame() {
        return gameState.isEndGame();
    }
}
