package constants;

public enum HintMessage {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String hint;
    HintMessage(String hint){
        this.hint = hint;
    }

    public String getHint(){
        return hint;
    }
}