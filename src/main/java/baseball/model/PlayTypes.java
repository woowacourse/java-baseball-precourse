package baseball.model;

import baseball.model.PlayType;

import java.util.List;

public class PlayTypes {

    List<PlayType> playTypes;

    public PlayTypes(List<PlayType> playTypes) {
        this.playTypes = playTypes;
    }

    public List<PlayType> getPlayType() {
        return playTypes;
    }
}
