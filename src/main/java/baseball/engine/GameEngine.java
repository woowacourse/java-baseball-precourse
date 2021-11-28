package baseball.engine;

import baseball.data.GameData;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

    public void start() {
        int[] judge;

        do {
            List<Integer> answer = generateAnswer();
            System.out.print(GameData.INPUT_NUMBER_MESSAGE);
            List<Integer> userNumber = parseUserNumber(inputUserNumber());
            judge = judge(answer, userNumber);
            System.out.println(getGameResult(judge));
        } while (checkGameEnd(judge));

        System.out.println(GameData.GAME_END_MESSAGE);
    }

    private List<Integer> generateAnswer() {
        List<Integer> results = new ArrayList<Integer>();

        while(results.size() < GameData.NUM_OF_ANSWER) {
            Integer number = Integer.valueOf(Randoms.pickNumberInRange(0, 9));
            if(!results.contains(number)) {
                results.add(number);
            }
        }

        return results;
    }

    private int inputUserNumber() {
        String text = Console.readLine();
        int result = 0;

        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(text, nfe);
        }

        return result;
    }

    private List<Integer> parseUserNumber(int userNumber) {
        List<Integer> results = new ArrayList<Integer>();

        do {
            results.add(Integer.valueOf(userNumber % 10));
            userNumber /= 10;
        } while (userNumber != 0);

        if(results.size() != GameData.NUM_OF_ANSWER) {
            throw new IllegalArgumentException(Integer.toString(userNumber));
        }

        Collections.reverse(results);

        return results;
    }

    private int[] judge(List<Integer> answer, List<Integer> userNumber) {
        int[] result = new int[2];
        for(int i = 0; i < GameData.NUM_OF_ANSWER; i++) {
            if(checkStrike(answer.get(i), userNumber.get(i))) {
                result[0]++;
                continue;
            } else if(checkBall(answer, userNumber.get(i))) {
                result[1]++;
            }
        }

        return result;
    }

    private String getGameResult(int[] judge) {
        StringBuilder stringBuilder = new StringBuilder();
        if(judge[1] != 0) {
            stringBuilder.append(String.format("%d%s", judge[1], GameData.BALL_MESSAGE));
        }
        if(judge[0] != 0) {
            if(stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(String.format("%d%s", judge[0], GameData.STRIKE_MESSAGE));
        }

        return stringBuilder.toString();
    }

    private boolean checkGameEnd(int[] judge) {
        return judge[0] == GameData.NUM_OF_ANSWER;
    }

    private boolean checkStrike(Integer answer, Integer userNumber) {
        return answer == userNumber;
    }

    private boolean checkBall(List<Integer> answer, Integer userNumber) {
        return answer.contains(userNumber);
    }

}
