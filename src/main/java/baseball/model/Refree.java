package baseball.model;

import static baseball.model.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Refree {

    public List<Integer> askPlayerAnswer(String playerInput) {
        inputValidate(playerInput);
        List<Integer> playerAnswer = new ArrayList<>();

        for (String digit : playerInput.split("")) {
            playerAnswer.add(Integer.parseInt(digit));
        }

        return playerAnswer;
    }

    private void inputValidate(String playerInput) {
        boolean regex = Pattern.matches(INPUT_VALIDATE_PATTERN, playerInput);
        if (!regex) {
            throw new IllegalArgumentException();
        }
    }

    public Map<String, Integer> compareAnswers(List<Integer> playerAnswer, List<Integer> gameAnswer) {
        Map<String, Integer> gameResultMap = new HashMap<>();
        int strikes = countStrikes(playerAnswer, gameAnswer);
        int balls = countBalls(playerAnswer, gameAnswer);
        gameResultMap.put(STRIKE, strikes);
        gameResultMap.put(BALL, balls);
        return gameResultMap;
    }

    private int countStrikes(List<Integer> playerAnswer, List<Integer> gameAnswer) {
        int strikes = 0;

        System.out.println(playerAnswer);
        System.out.println(gameAnswer);

        for (int i = 0; i < gameAnswer.size(); i++) {
            if (gameAnswer.get(i) == playerAnswer.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(List<Integer> playerAnswer, List<Integer> gameAnswer) {
        int balls = 0;

        for (int i = 0; i < gameAnswer.size(); i++) {
            int target = playerAnswer.get(i);

            if (target != gameAnswer.get(i) && gameAnswer.contains(target)) {
                balls++;
            }
        }
        return balls;
    }

    public boolean checkThreeStrikes(Map<String, Integer> gameResultMap) {
        return gameResultMap.get(STRIKE) == ANSWER_LENGTH;
    }

    public String makeGameResultMsg(Map<String, Integer> gameResultMap) {
        String strikesMsg = gameResultMap.get(STRIKE) + STRIKE;
        String ballsMsg = gameResultMap.get(BALL) + BALL;

        if (gameResultMap.get(STRIKE) == 0 && gameResultMap.get(BALL) == 0) {
            return NOTHING;
        }
        if (gameResultMap.get(STRIKE) != 0 && gameResultMap.get(BALL) == 0) {
            return strikesMsg;
        }
        if (gameResultMap.get(STRIKE) == 0 && gameResultMap.get(BALL) != 0) {
            return ballsMsg;
        }
        return strikesMsg + BLANK + ballsMsg;
    }
}
