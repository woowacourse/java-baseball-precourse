package baseball.domain;

public enum ExecutionFlagType {
    RESTART(1), STOP(2);

    private final int flagNumber;

    ExecutionFlagType(int flagNumber) {
        this.flagNumber = flagNumber;
    }

    public int getFlagNumber() {
        return this.flagNumber;
    }
}
