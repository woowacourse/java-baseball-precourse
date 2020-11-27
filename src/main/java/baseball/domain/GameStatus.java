package baseball.domain;

public class GameStatus {
    private Status status;

    public GameStatus(Status status) {
        this.status = status;
    }

    public boolean isOngoing() {
        return status == Status.ONGOING;
    }

    public void terminate() {
        status = Status.TERMINATED;
    }
}
