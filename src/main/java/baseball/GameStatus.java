package baseball;

/**
 * 게임 상태를 나타냅니다.
 * 
 * ONGOING 아직 게임이 진행되는 상태입니다. RESTART 게임 한 판이 종료되고 재시작을 선택한 상태입니다. END 게임 한 판이 종료되고 게임 종료를 선택한
 * 상태입니다. WAIT 정답을 맞추어 재시작을 할 것인지 대기하는 상태입니다.
 * 
 * @author junroot
 */
public enum GameStatus {
    ONGOING("0"), RESTART("1"), END("2"), WAIT("3");

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
