package baseball.domain.value;

public enum Result {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String korean;

    Result(String korean){
        this.korean = korean;
    }

    public String getKorean(){
        return this.korean;
    }
}
