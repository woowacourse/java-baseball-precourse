package baseball;

enum DeterminationPitching {
    STRIKE_ENGLISH("strike"),
    BALL_ENGLISH("ball"),
    STRIKE_KOREAN("스트라이크"),
    BALL_KOREAN("볼"),
    NOTHING("낫싱");

    private final String determinationPitching;

    DeterminationPitching(final String determinationPitching) {
        this.determinationPitching = determinationPitching;
    }

    private String determinePitching() {
        return determinationPitching;
    }
}
