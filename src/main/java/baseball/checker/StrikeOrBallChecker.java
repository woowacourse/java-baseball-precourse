package baseball.checker;

import static baseball.checker.types.EachNumberResultType.BALL;
import static baseball.checker.types.EachNumberResultType.NOTHING;
import static baseball.checker.types.EachNumberResultType.STRIKE;

import baseball.checker.types.EachNumberResultType;
import baseball.players.Computer;
import baseball.players.User;

public class StrikeOrBallChecker {
    private final User user;
    private final Computer computer;

    public StrikeOrBallChecker(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public EachNumberResultType resultOfEachNumber(int userIndex, int computerIndex) {
        int userNumber = user.numberIndexOf(userIndex);
        int computerNumber = computer.numberIndexOf(computerIndex);
        if ((userNumber == computerNumber) && (userIndex == computerIndex)) {
            return STRIKE;
        }
        if ((userNumber == computerNumber) && (userIndex != computerIndex)) {
            return BALL;
        }
        return NOTHING;
    }
}
