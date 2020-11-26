package baseball.domain.judge;

public enum Judgement {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String koreanName;

    Judgement(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return this.koreanName;
    }
}
