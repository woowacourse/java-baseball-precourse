package baseball.game;

import baseball.player.PlayerService;

public class GameService {

    private PlayerService playerService;

    public GameService(){
        this.playerService = new PlayerService();
    }

    public String getGameResult() {
        return createGameResult();
    }

    public String createGameResult() {
        int strikeScore = playerService.getStrikeScore();
        int ballScore = playerService.getBallScore();

        StringBuilder result = new StringBuilder();
        if(ballScore == 0 && strikeScore == 0) {
            result.append("낫싱");
        }
        else if(strikeScore == 0) {
            result.append(ballScore).append("볼");
        }
        else if(ballScore == 0) {
            result.append(strikeScore).append("스트라이크");
        }
        else {
            result.append(ballScore).append("볼 ")
                    .append(strikeScore).append("스트라이크");
        }

        return result.toString();
    }
}
