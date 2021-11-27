package baseball.constants;

public enum HintMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String message;
    HintMessage(String message){
        this.message = message;
    }

    public String hint(){
        return message;
    }
}
