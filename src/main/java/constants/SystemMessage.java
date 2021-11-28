package constants;


public enum SystemMessage {

    INPUT_REQUEST("숫자를 입력해주세요 : "),
    GAME_CLEAR("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_END_REQUEST("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    SystemMessage(String message) {

        this.message = message;
    }

    public String getMessage(){

        return message;
    }
}

