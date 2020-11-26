package baseball.domain;

public class RestartManager {
    private static final String RESTART_REQUEST = "1";
    private static final String STOP_REQUEST = "2";
    private static final String RESTART_OR_STOP_REQUEST_ERROR_MESSAGE = "1 또는 2만 입력해주세요!";

    private final boolean restartable;

    public RestartManager(String restartOrStopRequest) {
        validateRestartManager(restartOrStopRequest);
        if (restartOrStopRequest.equals(RESTART_REQUEST)) {
            restartable = true;
            return;
        }

        restartable = false;
    }

    private void validateRestartManager(String restartOrStopRequest) {
        if (!restartOrStopRequest.equals(RESTART_REQUEST) && !restartOrStopRequest.equals(STOP_REQUEST)) {
            throw new IllegalArgumentException(RESTART_OR_STOP_REQUEST_ERROR_MESSAGE);
        }
    }

    public boolean canRestart() {
        return restartable;
    }
}
