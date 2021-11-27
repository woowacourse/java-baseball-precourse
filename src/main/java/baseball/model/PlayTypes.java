package baseball.model;

import java.util.List;

public class PlayTypes {

    List<PlayType> playTypes;

    public PlayTypes(List<PlayType> playTypes) {
        this.playTypes = playTypes;
    }

    public List<PlayType> getPlayType() {
        return playTypes;
    }

    public String getPlayResult() {
        long ballCount = playTypes.stream().filter(PlayType.BALL::equals).count();
        long strikeCount = playTypes.stream().filter(PlayType.STRIKE::equals).count();
        StringBuilder stringBuilder = new StringBuilder();
        if (ballCount != 0) {
            stringBuilder.append(ballCount).append(PlayType.BALL.getName());
        }
        if (ballCount != 0 && strikeCount != 0) {
            stringBuilder.append(" ");
        }
        if (strikeCount != 0) {
            stringBuilder.append(strikeCount).append(PlayType.STRIKE.getName());
        }
        if (ballCount == 0 && strikeCount == 0) {
            stringBuilder.append(PlayType.NOTHING.getName());
        }
        return stringBuilder.toString();
    }
}
