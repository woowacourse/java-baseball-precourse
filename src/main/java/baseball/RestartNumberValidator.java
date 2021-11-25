package baseball;

/**
 * 사용자에게 입력받은 재시작 여부가 올바른지 검증하는 클래스
 * 올바르지 않을 경우 예외를 발생시키고 종료시킨다.
 */
public class RestartNumberValidator {
    private String isRestart;

    public RestartNumberValidator(String isRestart) {
        this.isRestart=isRestart;
    }

    public boolean rightInputRestartCheck(){
        return isRestart.equals(Game.RESTART) || isRestart.equals(Game.EXIT);
    }
}
