package baseball;

public class GameManager {
    private boolean isGameInProgress;

    public GameManager() {
        isGameInProgress = true;
    }

    public boolean isGameInProgress() {
        return isGameInProgress;
    }

    public void setGameStatus(int statusCode) {
        switch (statusCode) {
            case GameStatusCode.RESUME:
                break;
            case GameStatusCode.RESTART:
                break;
            case GameStatusCode.EXIT:
                isGameInProgress = false;
                break;
            default:
                throw new IllegalArgumentException("재시작하고 싶으시면 1, 종료하고 싶으시면 2를 입력해주세요");
        }
    }
}
