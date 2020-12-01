package baseball.domain;

public enum Status {
    EXECUTION("1"),
    TERMINATION("2");

    final private String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
