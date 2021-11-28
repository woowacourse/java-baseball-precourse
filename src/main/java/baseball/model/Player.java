package baseball.model;

import baseball.util.GamePlayType;

public class Player {
    private int[] answer;
    private GamePlayType gamePlayType;

    public Player() {
        this.gamePlayType = GamePlayType.GAME_PLAY;
    }

    public int[] getAnswer() {
        return answer;
    }

    public GamePlayType getGamePlayType() {
        return gamePlayType;
    }

    public void guessAnswer() {
        // ToDo: 정답 추측
    }

    public void selectGamePlayType() {
        // ToDo: 게임 플레이 여부 선택
    }
}
