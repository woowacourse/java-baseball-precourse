package enums;

public enum RefereeCall {
    BALL("볼 "),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    OUT_3STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    ASK_REGAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    REQUEST_NUMBER("숫자를 입력해주세요 : ");

    String call = "";

    RefereeCall(String call) {
        this.call = call;
    }

    public String getCall() {
        return call;
    }
}
