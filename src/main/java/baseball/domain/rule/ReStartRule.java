package baseball.domain.rule;

import baseball.domain.constants.ConstantsNumbers;

public class ReStartRule {
    public boolean isRestart(String restartInput) {

        if(isValidRestartNumber(restartInput)) {
            return ConstantsNumbers.RESTART_NUMBER == Integer.valueOf(restartInput);
        }
        throw new IllegalArgumentException();
    }

    private boolean isValidRestartNumber(String restartInput) {
        return ConstantsNumbers.RESTART_NUMBER == Integer.valueOf(restartInput) || ConstantsNumbers.GAME_THE_END_NUMBER == Integer.valueOf(restartInput);
    }
}
