package baseball.domain;

public class RestartManager {
    private static final String RESTART_REQUEST = "1";
    private static final String STOP_REQUEST = "2";
    private static final String RESTART_OR_STOP_REQUEST_ERROR_MESSAGE = "1 또는 2만 입력해주세요!";

    private final boolean restartable;

    private RestartManager(boolean restartable) {
        this.restartable = restartable;
    }

    public static RestartManager of(String restartOrStopRequest) {
        if (restartOrStopRequest.equals(RESTART_REQUEST)) {
            return new RestartManager(true);
        }

        if (restartOrStopRequest.equals(STOP_REQUEST)) {
            return new RestartManager(false);
        }

        throw new IllegalArgumentException(RESTART_OR_STOP_REQUEST_ERROR_MESSAGE);
    }

    public boolean canRestart() {
        return restartable;
    }
}
