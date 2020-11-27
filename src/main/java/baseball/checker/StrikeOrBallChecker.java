package baseball.checker;

import static baseball.checker.types.EachNumberResultType.BALL;
import static baseball.checker.types.EachNumberResultType.NOTHING;
import static baseball.checker.types.EachNumberResultType.STRIKE;

import baseball.checker.dtos.ResultCheckDto;
import baseball.checker.types.EachNumberResultType;

public class StrikeOrBallChecker {
    public static EachNumberResultType resultOfEachNumber(ResultCheckDto resultCheckDto) {
        int userIndex = resultCheckDto.getUserIndex();
        int computerIndex = resultCheckDto.getComputerIndex();
        int userNumber = resultCheckDto.getUserNumberIndexOf(userIndex);
        int computerNumber = resultCheckDto.getComputerNumberIndexOf(computerIndex);
        if ((userNumber == computerNumber) && (userIndex == computerIndex)) {
            return STRIKE;
        }
        if ((userNumber == computerNumber) && (userIndex != computerIndex)) {
            return BALL;
        }
        return NOTHING;
    }
}
