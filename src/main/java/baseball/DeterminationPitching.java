package baseball;

enum DeterminationPitching {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String determinationPitching;

    DeterminationPitching(final String determinationPitching) {
        this.determinationPitching = determinationPitching;
    }

    String determinePitching() {
        return this.determinationPitching;
    }
}
