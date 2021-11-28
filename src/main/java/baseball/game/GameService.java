package baseball.game;

public class GameService {

    private GameService() {}

    private static class InnerInstanceClazz {
        private static final GameService instance = new GameService();
    }

    public static GameService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public String getGameResult(int strikeScore, int ballScore) {
        return createGameResult(strikeScore, ballScore);
    }

    public String createGameResult(int strikeScore, int ballScore) {

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
